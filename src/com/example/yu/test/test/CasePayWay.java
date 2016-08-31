package com.example.yu.test.test;

import com.example.yu.test.test.RunTestCase.*;
import com.robotium.solo.Solo;

import android.view.View;
public class CasePayWay extends BaseCase {
	public static String tag = "CasePayWay";

	public static CasePayWay caseInstance(Solo solo1) {
		CasePayWay instance = new CasePayWay();
		instance.instance(solo1);
		return instance;
	}

	public void test_run() {
		payWay();
		separate();
	}

	/**
	 * 全额支付及支付方式
	 */
	public void payWay() {
		login_sure(Config.pNum_reg);
		/**
		 * 金额不足3000的无法选择分次支付
		 */
		t("化肥专场");
		solo.clickInList(2);
		t("立即购买");
		t("确定");
		t("配送到户");
		v("com.ksfc.newfarmer:id/ordering_go_bt");
		// 判断待付金额与全额支付金额是否一致
		String all_one = getTextViewString("com.ksfc.newfarmer:id/payway_sumPrice");
		String all = all_one.substring(0, all_one.length() - 2);
		String wait_one = getTextViewString("com.ksfc.newfarmer:id/payWay_pay_total_price");
		String wait = wait_one.substring(1, wait_one.length() - 1);
		if (!all.equals(wait)) {
			showErrLog(tag + ":payWay():判断待付金额与全额支付金额是否一致");
		}
		// 测试能否分次支付
		t("分次支付");
		View view_one = solo
				.getView("com.ksfc.newfarmer:id/payWay_discount_jia");
		View view_two = solo
				.getView("com.ksfc.newfarmer:id/payWay_discount_jian");
		if (view_one.isEnabled() | view_two.isEnabled()) {
			showErrLog(tag + ":payWay():测试能否分次支付");
		}
		// 支付宝支付
		t("全额支付");
		v("com.ksfc.newfarmer:id/alipay_ll");
		t("去支付");
		solo.sleep(1000);
		/**
		 * EPSO支付
		 */
		// EPOS刷卡全额支付
		v("com.ksfc.newfarmer:id/pos_ll");
		t("去支付");
		if (!solo.searchText("全民付EPOS", 1, false, true)) {
			showErrLog(tag + ":payWay():EPOS刷卡全额支付");
		}
		// EPSO支付页面查看其他网点
		v("com.ksfc.newfarmer:id/view_other_state_ll");
		if (!solo.searchText("EPOS刷卡网点", 1, false, true)) {
			showErrLog(tag + ":payWay():EPSO支付页面查看其他网点");
		}
		g();
		// EPOS已在服务点立即支付
		t("立即支付");
		g();
		if (!solo.waitForText("支付失败")) {
			showErrLog(tag + ":payWay():EPOS已在服务点立即支付");
		}
		g();
		/**
		 * 线下支付
		 */
		// 进入线下支付页面
		v("com.ksfc.newfarmer:id/bank_dianhui_ll");
		t("去支付");
		if (!solo.searchText("线下支付", 1, false, true)) {
			showErrLog(tag + ":payWay():进入线下支付页面");
		}
		// 线下付款页面去查看订单
		t("查看订单");
		if (!solo.searchText("订单详情", 1, false, true)) {
			showErrLog(tag + ":payWay():线下付款页面去查看订单");
		}
		// 订单详情页面查看订单状态
		v("com.ksfc.newfarmer:id/my_order_detail_id");
		if (!solo.searchText("订单状态", 1, false, true)) {
			showErrLog(tag + ":payWay():订单详情页面查看付款审核状态");
		}
		g();
		// 订单详情页面查看付款信息
		v("com.ksfc.newfarmer:id/go_to_pay");
		if (!solo.searchText("线下支付", 1, false, true)) {
			showErrLog(tag + ":payWay():订单详情页面查看付款信息");
		}
		g();
		// 订单详情页面去修改支付方式
		v("com.ksfc.newfarmer:id/change_pay_type");
		if (!solo.searchText("支付方式", 1, false, true)) {
			showErrLog(tag + ":payWay():订单详情页面去修改支付方式");
		}
		g();
		g();
		g();
	}

	/**
	 * 分次支付
	 */
	public void separate() {
		login_sure(Config.pNum_reg);
		t("化肥专场");
		solo.clickInList(5);
		t("立即购买");
		t("确定");
		t("配送到户");
		v("com.ksfc.newfarmer:id/ordering_go_bt");
		// 判断待付金额与全额支付金额是否一致
		String all_one = getTextViewString("com.ksfc.newfarmer:id/payway_sumPrice");
		String all = all_one.substring(0, all_one.length() -1);
		String wait_one = getTextViewString("com.ksfc.newfarmer:id/payWay_pay_total_price");
		String wait = wait_one.substring(1, wait_one.length());
		double pay_wait = Double.parseDouble(all);
		if (!all.equals(wait)) {
			showErrLog(tag + ":separate():判断待付金额与全额支付金额是否一致");
		}
		t("分次支付");
		//线下支付不能分次
		if(solo.searchText("线下支付",1,false,true)){
			showErrLog(tag + ":separate():线下支付不能分次");
		}
		// 获取分次支付的金额看初始值是否为3000
		String s = getTextViewString("com.ksfc.newfarmer:id/payWay_discount_price");
		double pay_reality = Double.parseDouble(s);
		if (pay_reality != 3000.00) {
			showErrLog(tag + ":separate():获取分次支付的金额看初始值是否为3000");
		}

		// 分次支付不停增加支付金额直到等于待付金额
		while (pay_reality != pay_wait) {
			v("com.ksfc.newfarmer:id/payWay_discount_jia");
			s = getTextViewString("com.ksfc.newfarmer:id/payWay_discount_price");
			double pay_reality_jia = Double.parseDouble(s);
			pay_reality = pay_reality_jia;
		}
		if (pay_reality != pay_wait) {
			showErrLog(tag + ":separate():分次支付不停增加支付金额直到等于待付金额");
		}

		// 分次支付不停减少支付金额直到等于默认金额
		while (pay_reality != 3000) {
			v("com.ksfc.newfarmer:id/payWay_discount_jian");
			s = getTextViewString("com.ksfc.newfarmer:id/payWay_discount_price");
			double pay_reality_jian = Double.parseDouble(s);
			pay_reality = pay_reality_jian;
		}
		if (pay_reality != 3000.00) {
			showErrLog(tag + ":separate():分次支付不停减少支付金额直到等于默认金额");
		}
		//支付宝分次支付
		v("com.ksfc.newfarmer:id/alipay_ll");
		t("去支付");
		solo.sleep(1000);
		// EPOS分次支付
		v("com.ksfc.newfarmer:id/pos_ll");
		t("去支付");
		if(!solo.searchText("全民付EPOS",1,false,true)){
			showErrLog(tag+":separate():EPOS分次支付");
		}
	}
}