package com.example.yu.test.test;

import android.view.View;
import android.widget.ListView;

import com.example.yu.test.test.RunTestCase.*;
import com.robotium.solo.Solo;

public class CaseNewFarmer_delegate extends BaseCase {

	String tag = "CaseShoppingCar";

	public static CaseNewFarmer_delegate caseInstance(Solo solo1) {
		CaseNewFarmer_delegate instance = new CaseNewFarmer_delegate();
		instance.instance(solo1);
		return instance;
	}

	public void test_run() {
		delegate_null();
		delegate();
		add();
	}

	/**
	 * 没有代表，客户的账户
	 */
	public void delegate_null() {

		login_sure(Config.pNum_null);
		t("我的");
		t("新农代表");
		// 没有客户的账户我的客户页面展示
		if (!solo.searchText("您没有邀请用户哦~", 1, false, true)) {
			showErrLog(tag + ":delegate_null():没有客户的账户我的客户页面展示");
		}
		// 没有代表的账户我的代表页面展示
		v("com.ksfc.newfarmer:id/radio_button2");
		if (!solo.searchText("*代表人添加后不可修改,请仔细核对", 1, false, true)) {
			showErrLog(tag + ":delegate_null():没有代表的账户我的代表页面展示");
		}
		/**
		 * 添加新农代表（为了方便以后测试，不进行正确保存代表的操作）
		 */
		// 未填写手机号就添加
		v("com.ksfc.newfarmer:id/add_inviter");
		if (!solo.waitForText("请输入一个手机号码")) {
			showErrLog(tag + ":delegate_null():未填写手机号就添加");
		}
		// 填写错误的手机号码
		enter("com.ksfc.newfarmer:id/my_inviter_fragment_edittext",
				Config.pNum_err);
		v("com.ksfc.newfarmer:id/add_inviter");
		if (!solo.waitForText("您输入的手机号码不正确")) {
			showErrLog(tag + ":delegate_null():填写错误的手机号码");
		}
		g();
	}

	/**
	 * 有客户代表且已认证为新农经纪人的账户
	 */
	public void delegate() {
		login_sure(Config.pNum_reg);
		t("我的");
		t("新农代表");
		// 我的客户页面去查看客户订单
		v("com.ksfc.newfarmer:id/my_inviter_nickname");
		if (!solo.searchText("客户订单")) {
			showErrLog(tag + ":delegate():我的客户页面去查看客户订单");
		}
		/**
		 * 我的客户订单状态更新时有红点提示
		 */
		// 使用客户账号下单并返回新农代表的账户查看
		g();
		g();
		t("首页");
		login_sure("13718603051");
		t("化肥专场");
		solo.clickInList(2);
		t("立即购买");
		t("确定");
		v("com.ksfc.newfarmer:id/deliveries_way_home");
		v("com.ksfc.newfarmer:id/ordering_go_bt");
		g();
		login_sure(Config.pNum_reg);
		t("我的");
		t("新农代表");
		// 客户订单状态有更新
		View view = solo
				.getView("com.ksfc.newfarmer:id/my_inviter_nickname_remind_dot");
		if (view.getVisibility() != View.VISIBLE) {
			showErrLog(tag + ":delegate():客户订单状态有更新");
		}
		// 查看过客户订单后小红点消失
		v("com.ksfc.newfarmer:id/my_inviter_nickname");
		g();
		view = solo
				.getView("com.ksfc.newfarmer:id/my_inviter_nickname_remind_dot");
		if (view.getVisibility() != View.INVISIBLE) {
			showErrLog(tag + ":delegate():查看过客户订单后小红点消失");
		}

		/**
		 * 我的代表
		 */
		// 在我的代表页面点击拨打电话按钮
		t("我的代表");
		if (!(solo.searchText("添加", 1, false, true))) {
			v("com.ksfc.newfarmer:id/my_inviter_phone_icon");
			t("取消");
		}// 进入我的代表页面并尝试拨打电话
		v("com.ksfc.newfarmer:id/radio_button2");
		v("com.ksfc.newfarmer:id/my_inviter_phone_icon");
		if (!solo.searchText("拨打")) {
			showErrLog(tag + ":delegate():进入我的代表页面并尝试拨打电话");
		}
		solo.clickOnButton("取消");

		/**
		 * 客户登记
		 */
		// 客户登记页面查看客户订单
		v("com.ksfc.newfarmer:id/item_already_customer_name");
		if (!solo.searchText("客户详情")) {
			showErrLog(tag + ":delegate():客户登记页面查看客户订单");
		}
		g();
		g();
	}

	/**
	 * 添加潜在客户
	 */
	public void add() {
		login_sure(Config.pNum_reg);
		t("我的");
		t("新农代表");
		t("客户登记");
		// 未选择地区时不能选择街道
		v("com.ksfc.newfarmer:id/choice_town_text");
		if (!solo.waitForText("请先选择地区")) {
			showErrLog(tag + ":add():未选择地区时不能选择街道");
		}
		// 未填写姓名保存
		v("com.ksfc.newfarmer:id/add_potential_customer");
		t("保存");
		if (!solo.waitForText("请完善信息")) {
			showErrLog(tag + ":add():未填写姓名保存");
		}
		// 姓名长度不能超过12个字符
		enter("com.ksfc.newfarmer:id/name_tv", getRandomString(16));
		if (getTextViewString("com.ksfc.newfarmer:id/name_tv").length() != 12) {
			showErrLog(tag + ":add():姓名长度不能超过12个字符");
		}
		// 未填写手机号保存
		t("保存");
		if (!solo.waitForText("请完善信息")) {
			showErrLog(tag + ":add():未填写手机号保存");
		}
		// 填写错误的手机号
		enter("com.ksfc.newfarmer:id/phone_tv", Config.pNum_err);
		if (!solo.waitForText("请完善信息")) {
			showErrLog(tag + ":add():填写错误的手机号");
		}
		// 填写已注册过的手机号
		clear("com.ksfc.newfarmer:id/phone_tv");
		enter("com.ksfc.newfarmer:id/phone_tv", Config.pNum_reg);
		if (!solo.searchText("该客户已注册，可让其直接添加您为新农代表，方便您跟踪订单与提供服务")) {
			showErrLog(tag + ":delegate():填写已注册过的手机号");
		}
		// 填写已登记过的手机号
		clear("com.ksfc.newfarmer:id/phone_tv");
		enter("com.ksfc.newfarmer:id/phone_tv", "13333333333");
		if (!solo.searchText("com.ksfc.newfarmer:id/phone_error")) {
			showErrLog(tag + ":delegate():填写已登记过的手机号");
		}
		clear("com.ksfc.newfarmer:id/phone_tv");
		enter("com.ksfc.newfarmer:id/phone_tv", "133" + getRandomIntString(8));
		// 选择性别为男
		if (!solo.isCheckBoxChecked(1)) {
			v("com.ksfc.newfarmer:id/btn_check_item_item");
			if (solo.isCheckBoxChecked(4)) {
				showErrLog(tag + ":delegate():选择性别为男");
			}
		} else {
			v("com.ksfc.newfarmer:id/btn_check_item_item1");
			if (solo.isCheckBoxChecked(1)) {
				showErrLog(tag + ":delegate():选择性别为女");
			}
		}
		// 未填写地区
		t("保存");
		if (!solo.waitForText("请完善信息")) {
			showErrLog(tag + ":add():未填写地区");
		}
		// 未填写街道
		v("com.ksfc.newfarmer:id/choice_city_layout");
		solo.clickInList(1);
		solo.clickInList(getRandomInt(1, 12));
		solo.clickInList(getRandomInt(1, 6));
		t("保存");
		if (!solo.waitForText("请完善信息")) {
			showErrLog(tag + ":add():未填写街道");
		}
		// 未填写意向产品保存
		v("com.ksfc.newfarmer:id/choice_town_layout");
		solo.clickInList(getRandomInt(1, 4));
		t("保存");
		if (!solo.waitForText("请完善信息")) {
			showErrLog(tag + ":add():未填写意向产品保存");
		}
		// 重新选择地区看街道是否重置
		v("com.ksfc.newfarmer:id/choice_city_layout");
		solo.clickInList(1);
		solo.clickInList(getRandomInt(1, 12));
		solo.clickInList(getRandomInt(1, 6));
		if (!getTextHintString("com.ksfc.newfarmer:id/choice_town_text")
				.equalsIgnoreCase("选择所在街道或乡镇")) {
			showErrLog(tag + ":add(): 重新选择地区看街道是否重置");
		}
		//不选择意向产品就确定
		v("com.ksfc.newfarmer:id/choice_town_layout");
		solo.clickInList(getRandomInt(1, 4));
		v("com.ksfc.newfarmer:id/choose_type_ll");
		t("确定");
		if (!solo.waitForText("请至少选择一个意向产品")) {
			showErrLog(tag + ":add():不选择意向产品就确定");
		}
		

	}
}