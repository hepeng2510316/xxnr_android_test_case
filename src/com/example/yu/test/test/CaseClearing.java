package com.example.yu.test.test;

import com.example.yu.test.test.RunTestCase.*;
import com.robotium.solo.Solo;
import com.squareup.spoon.Spoon;

import android.view.View;

public class CaseClearing extends BaseCase {
	public static String tag = "CaseClearing";

	public static CaseClearing caseInstance(Solo solo1) {
		CaseClearing instance = new CaseClearing();
		instance.instance(solo1);
		return instance;
	}

	public void test_run() {
	//	delivery();
	//	net();
		separate();
		
	}

	/**
	 * 配送到户
	 */
	public void delivery() {

		login_sure(Config.pNum_reg);
		t("购物车");
		// 向购物车内添加支持配送到户的商品并进入到提交订单页面
		if (!solo.searchText("去买化肥", 1, false, true)) {
			v("com.ksfc.newfarmer:id/btn_check_all");
			t("编辑");
			v("com.ksfc.newfarmer:id/ordering_go_bt");
			solo.clickOnButton("是");
		}

		t("去买化肥");
		solo.clickInList(2);
		t("加入购物车");
		t("确定");
		v("com.ksfc.newfarmer:id/title_right_img");
		v("com.ksfc.newfarmer:id/btn_check_all");
		v("com.ksfc.newfarmer:id/ordering_go_bt");
		v("com.ksfc.newfarmer:id/deliveries_way_home");// 选择配送到户

		/**
		 * 收货地址为空时提交订单
		 */
		if (solo.searchText("添加收货地址", 1, false, true)) {
			v("com.ksfc.newfarmer:id/ordering_go_bt");
			if (!solo.waitForText("收货地址不能为空")) {
				showErrLog(tag + ":delivery():没有收货地址时点击提交订单");
			}
		} else {
			v("com.ksfc.newfarmer:id/address_shouhuo_ll");
			while (!solo.searchText("您还没有收货地址哦，添加一个吧~", 1, false, true)) {
				v("com.ksfc.newfarmer:id/delete_address_img");
				v("com.ksfc.newfarmer:id/btn_sure");
			}
			g();
			v("com.ksfc.newfarmer:id/ordering_go_bt");
			if (!solo.waitForText("收货地址不能为空")) {
				showErrLog(tag + ":delivery():没有收货地址时点击提交订单");
			}
		}

		/**
		 * 添加收货地址
		 */
		v("com.ksfc.newfarmer:id/add_address_shouhuo_ll");
		v("com.ksfc.newfarmer:id/title_right_text");
		// 未填写收货人姓名就保存
		clear("com.ksfc.newfarmer:id/shouhuo_name");
		t("保存");
		if (!solo.waitForText("请输入收货人姓名")) {
			showErrLog(tag + ":delivery():未填写收货人姓名就保存");
		}
		// 未填写手机号
		enter("com.ksfc.newfarmer:id/shouhuo_name", getRandomString(6));
		clear("com.ksfc.newfarmer:id/shouhuo_tel");
		t("保存");
		if (!solo.waitForText("请输入手机号码")) {
			showErrLog(tag + ":delivery():未填写手机号");
		}
		// 填写错误的手机号
		enter("com.ksfc.newfarmer:id/shouhuo_tel", Config.pNum_err);
		t("保存");
		if (!solo.waitForText("请输入正确的手机号码")) {
			showErrLog(tag + ":delivery():填写错误的手机号");
		}
		// 填写正确的手机号，但是没有填写地址
		clear("com.ksfc.newfarmer:id/shouhuo_tel");
		enter("com.ksfc.newfarmer:id/shouhuo_tel", Config.pNum_reg);
		t("保存");
		if (!solo.waitForText("请选择城市")) {
			showErrLog(tag + ":delivery():填写正确的手机号，但是没有填写地址");
		}
		// 选择完城市和乡镇后重新选择城市，看乡镇是否随之重置
		v("com.ksfc.newfarmer:id/choice_city_layout");
		solo.clickInList(1);
		solo.clickInList(getRandomInt(1, 12));
		solo.clickInList(getRandomInt(1, 7));
		v("com.ksfc.newfarmer:id/choice_town_layout");
		solo.clickInList(getRandomInt(1, 5));
		v("com.ksfc.newfarmer:id/choice_city_layout");
		solo.clickInList(1);
		solo.clickInList(getRandomInt(1, 12));
		solo.clickInList(getRandomInt(1, 7));
		if (!getTextHintString("com.ksfc.newfarmer:id/choice_town_text")
				.contains("请选择乡镇")) {
			showErrLog(tag + ":delivery():选择完城市和乡镇后重新选择城市，看乡镇是否随之重置");
		}
		// 未填写详细地址
		t("保存");
		if (!solo.waitForText("请输入您的详细地址")) {
			showErrLog(tag + ":delivery():未填写详细地址");
		}
		// 输入字符串长度超过50的详细地址
		enter("com.ksfc.newfarmer:id/choice_detail_room_edit",
				getRandomString(55));
		if (getEditTextString("com.ksfc.newfarmer:id/choice_detail_room_edit")
				.length() != 50) {
			showErrLog(tag + ":delivery():输入字符串长度超过50的详细地址");
		}
		// 成功保存地址
		t("保存");
		if (!solo.waitForText("成功新增了地址")) {
			showErrLog(tag + ":delivery():成功保存地址");
		}

		/**
		 * 编辑收货地址
		 */
		// 在编辑地址页面删除地址
		v("com.ksfc.newfarmer:id/edit_address_img");
		v("com.ksfc.newfarmer:id/choose_address_delete");
		v("com.ksfc.newfarmer:id/btn_sure");
		if (!solo.searchText("您还没有收货地址哦，添加一个吧~", 1, false, true)) {
			showErrLog(tag + ":delivery():在编辑地址页面删除地址");
		}
		addAddress();
		// 在收货地址页面删除地址
		v("com.ksfc.newfarmer:id/delete_address_img");
		v("com.ksfc.newfarmer:id/btn_sure");
		if(!solo.searchText("您还没有收货地址哦，添加一个吧~", 1, false, true)){
			showErrLog(tag + ":delivery():在编辑地址页面删除地址");
		}
		addAddress();
		g();
		// 成功提交订单
		v("com.ksfc.newfarmer:id/ordering_go_bt");
		solo.assertCurrentActivity(tag + ":delivery():成功提交订单", "PaywayActivity");
		g();
	}

	/**
	 * 网点自提
	 */
	public void net() {
		t("购物车");
		// 向购物车中添加网点不同的商品，看是否有重选文字提示
		if (!solo.searchText("去买汽车", 1, false, true)) {
			v("com.ksfc.newfarmer:id/btn_check_all");
			t("编辑");
			v("com.ksfc.newfarmer:id/ordering_go_bt");
			solo.clickOnButton("是");
		}
		t("去买化肥");
		solo.clickInList(1);
		t("加入购物车");
		t("2-2-2");
		t("40",2);
		t("确定");
		g();
		g();
		t("首页");
		t("汽车专场");
		solo.clickInList(2);
		t("加入购物车");
		t("确定");
		v("com.ksfc.newfarmer:id/title_right_img");
		v("com.ksfc.newfarmer:id/btn_check_all");
		v("com.ksfc.newfarmer:id/ordering_go_bt");
		if (!solo.searchText("您选择的商品不能在同一个网点自提，请返回购物车重新选择", 1, false, true)) {
			showErrLog(tag + ":net():向购物车中添加网点不同的商品，看是否有重选文字提示");
		}
		// 向购物车中添加网点不同的商品，看是否能提交订单
		v("com.ksfc.newfarmer:id/ordering_go_bt");
		if (!solo.waitForText("您选择的商品不能在同一个网点自提，请返回购物车重新选择")) {
			showErrLog(tag + ":net():向购物车中添加网点不同的商品，看是否能提交订单");
		}
		// 往购物车中添加车并选择该汽车去结算
		g();
		if (!solo.searchText("去买汽车", 1, false, true)) {
			v("com.ksfc.newfarmer:id/btn_check_all");
			t("编辑");
			v("com.ksfc.newfarmer:id/ordering_go_bt");
			solo.clickOnButton("是");
		}
		t("去买汽车");
		solo.clickInList(1);
		s();
		t("加入购物车");
		t("1.5L 手动（MT）");
		t("豪华型");
		t("炫酷黑");
		t("确定");
		v("com.ksfc.newfarmer:id/title_right_img");
		solo.clickOnCheckBox(0);
		v("com.ksfc.newfarmer:id/ordering_go_bt");
		solo.assertCurrentActivity(tag + ":net():往购物车中添加车并选择该汽车去结算",
				"AddOrderActivity");

		// 没有选择网店的情况下提交订单
		v("com.ksfc.newfarmer:id/ordering_go_bt");
		if (!solo.waitForText("请选择自提网点")) {
			showErrLog(tag + ":net():没有选择网店的情况下提交订单");
		}

		/**
		 * 自提点
		 */
		// 判断在未选择具体网点的情况下，确定按钮是否能够点击
		v("com.ksfc.newfarmer:id/select_state_address_ll_state");
		View view = solo.getView("com.ksfc.newfarmer:id/save_userInfo");
		if (view.isEnabled()) {
			showErrLog(tag + ":net():判断在未选择具体网点的情况下，确定按钮是否能够点击");
		}
		v("com.ksfc.newfarmer:id/state_city_rel");
		solo.clickInList(getRandomInt(2, 4));
		View view2 = solo.getView("com.ksfc.newfarmer:id/save_userInfo");
		if (view2.isEnabled()) {
			showErrLog(tag + ":net():判断在未选择具体网点的情况下，确定按钮是否能够点击");
		}
		v("com.ksfc.newfarmer:id/state_county_rel");
		solo.clickInList(2);
		View view3 = solo.getView("com.ksfc.newfarmer:id/save_userInfo");
		if (view3.isEnabled()) {
			showErrLog(tag + ":net():判断在未选择具体网点的情况下，确定按钮是否能够点击");
		}

		// 让上一级地址变为全部地区，测试下一级地址是否变为全部地区
		v("com.ksfc.newfarmer:id/state_city_rel");
		solo.clickInList(1);
		String s = getTextViewString("com.ksfc.newfarmer:id/state_county_text");
		if (!s.equals("全部地区")) {
			showErrLog(tag + ":net():让上一级地址变为全部地区，测试下一级地址是否变为全部地区");
		}
		v("com.ksfc.newfarmer:id/state_city_rel");
		solo.clickInList(2);
		v("com.ksfc.newfarmer:id/state_province_rel");
		solo.clickInList(1);
		String s2 = getTextViewString("com.ksfc.newfarmer:id/state_city_text");
		if (!s2.equals("全部地区")) {
			showErrLog(tag + ":net():让上一级地址变为全部地区，测试下一级地址是否变为全部地区");
		}
		String s3 = getTextViewString("com.ksfc.newfarmer:id/state_county_text");
		if (!s3.equals("全部地区")) {
			showErrLog(tag + ":net():让上一级地址变为全部地区，测试下一级地址是否变为全部地区");
		}

		// 选择某一个自提点后返回上一页
		solo.clickInList(1);
		v("com.ksfc.newfarmer:id/save_userInfo");

		/**
		 * 选择收货人页面
		 */
		// 未填写收货人和手机号的情况下，测试确定按钮是否能点击
		v("com.ksfc.newfarmer:id/select_state_address_ll_person");
		View view4 = solo.getView("com.ksfc.newfarmer:id/name_submit_tv");
		if (view4.isEnabled()) {
			showErrLog(tag + ":net():未填写收货人和手机号的情况下，测试确定按钮是否能点击");
		}
		//收货人姓名不能超过12位字符
		enter("com.ksfc.newfarmer:id/shouhuo_name",getRandomString(15));
		if(getEditTextString("com.ksfc.newfarmer:id/shouhuo_name").length()!=12){
			showErrLog(tag+"net():收货人姓名不能超过12位字符");
		}
		// 填写格式错误的手机号
		enter("com.ksfc.newfarmer:id/shouhuo_tel", Config.pNum_err);
		t("确定");
		if (!solo.waitForText("请输入正确的手机号码")) {
			showErrLog(tag + ":net():填写格式错误的手机号");
		}
		// 填写格式正确的手机号并保存
		clear("com.ksfc.newfarmer:id/shouhuo_tel");
		enter("com.ksfc.newfarmer:id/shouhuo_tel", Config.pNum_reg);
		t("确定");

		// 根据历史收货人选择收货人
		v("com.ksfc.newfarmer:id/select_state_address_ll_person");
		solo.clickInList(3);
		// 成功提交订单
		v("com.ksfc.newfarmer:id/ordering_go_bt");
		solo.assertCurrentActivity(tag + ":net():成功提交订单", "PaywayActivity");
		g();
		t("首页");
	}
	
	/**
	 * 订单的拆分
	 */
	public void separate(){
		login_sure(Config.pNum_reg);
		t("购物车");
		if (!solo.searchText("去买化肥", 1, false, true)) {
			v("com.ksfc.newfarmer:id/btn_check_all");
			t("编辑");
			v("com.ksfc.newfarmer:id/ordering_go_bt");
			solo.clickOnButton("是");
		}
		t("去买化肥");
		solo.clickInList(2);
		t("加入购物车");
		t("确定");
		solo.clickInList(5);
		t("加入购物车");
		t("确定");
		v("com.ksfc.newfarmer:id/title_right_img");
		v("com.ksfc.newfarmer:id/btn_check_all");
		v("com.ksfc.newfarmer:id/ordering_go_bt");
		v("com.ksfc.newfarmer:id/deliveries_way_home");
		v("com.ksfc.newfarmer:id/ordering_go_bt");
		if(!solo.searchText("选择支付订单",1,false,true)){
			showErrLog(tag+":separate():订单的拆分");
		}
		//选择其中一个订单去支付
		v("com.ksfc.newfarmer:id/go_to_pay");
		solo.assertCurrentActivity(tag + ":separate():选择其中一个订单去支付", "PaywayActivity");
	}

	/**
	 * 在货地址页面添加地址
	 */
	public void addAddress() {
		v("com.ksfc.newfarmer:id/title_right_text");
		clear("com.ksfc.newfarmer:id/shouhuo_name");
		enter("com.ksfc.newfarmer:id/shouhuo_name", getRandomString(6));
		clear("com.ksfc.newfarmer:id/shouhuo_tel");
		enter("com.ksfc.newfarmer:id/shouhuo_tel", Config.pNum_reg);
		v("com.ksfc.newfarmer:id/choice_city_layout");
		solo.clickInList(1);
		int x = 1 + (int) (Math.random() * 12);
		solo.clickInList(x);
		int y = 1 + (int) (Math.random() * 5);
		solo.clickInList(y);
		enter("com.ksfc.newfarmer:id/choice_detail_room_edit", getRandomString(10));
		t("保存");
	}

}
