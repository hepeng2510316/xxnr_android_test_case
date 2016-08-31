package com.example.yu.test.test;


import com.example.yu.test.test.RunTestCase.*;
import com.robotium.solo.Solo;


public class CaseNewFarmer_apply extends BaseCase {

	public String tag = " CaseNewFarmer_apply";

	public static CaseNewFarmer_apply caseInstance(Solo solo1) {
		CaseNewFarmer_apply instance = new CaseNewFarmer_apply();
		instance.instance(solo1);
		return instance;
	}
	
	public void test_run(){
		newFarmer_business();
	}

	/**
	 * 认证县级经销商
	 */
	public void newFarmer_business() {
		// 登陆一个还没有申请县级经销商的账号
	//	login_sure(Config.pNum_null);
		t("我的");
		v("com.ksfc.newfarmer:id/head_View_bg");
		if (!(solo.searchText("县级经销商", 1, false, true))) {
			t("类型");
			t("县级经销商");
		}
		v("com.ksfc.newfarmer:id/choose_type_Certified_ll");

		// 在没有选择地区的情况下就去选择街道
		v("com.ksfc.newfarmer:id/choice_town_layout");
		if (!solo.waitForText("请先选择地区")) {
			showErrLog(tag + ":newFarmer_business():在没有选择地区的情况下就去选择街道");
		}
		// 没有填写姓名提交
		v("com.ksfc.newfarmer:id/choice_compelet");
		if (!solo.waitForText("请完善信息")) {
			showErrLog(tag + ":newFarmer_business():没有填写姓名提交");
		}
		// 姓名不能超过12位字符
		enter("com.ksfc.newfarmer:id/name_tv", getRandomString(16));
		if (getEditTextString("com.ksfc.newfarmer:id/name_tv").length() != 12) {
			showErrLog(tag + ":newFarmer_business():姓名不能超过12位字符");
		}
		// 未填写身份证号
		v("com.ksfc.newfarmer:id/choice_compelet");
		if (!solo.waitForText("请完善信息")) {
			showErrLog(tag + ":newFarmer_business(): 未填写身份证号");
		}
		// 未填写门店
		enter("com.ksfc.newfarmer:id/id_card_number_tv", getRandomIntString(18));
		v("com.ksfc.newfarmer:id/choice_compelet");
		if (!solo.waitForText("请完善信息")) {
			showErrLog(tag + ":newFarmer_business():未填写门店");
		}
		// 门店不能超过40个字符
		enter("com.ksfc.newfarmer:id/store_name_tv", getRandomString(50));
		if (getEditTextString("com.ksfc.newfarmer:id/store_name_tv").length() != 40) {
			showErrLog(tag + ":newFarmer_business():门店不能超过40个字符");
		}
		// 未填写联系电话
		v("com.ksfc.newfarmer:id/choice_compelet");
		if (!solo.waitForText("请完善信息")) {
			showErrLog(tag + ":newFarmer_business(): 未填写联系电话");
		}
		// 未填写地区
		enter("com.ksfc.newfarmer:id/phone_tv", Config.pNum_err);
		v("com.ksfc.newfarmer:id/choice_compelet");
		if (!solo.waitForText("请完善信息")) {
			showErrLog(tag + ":newFarmer_business(): 未填写地区");
		}
		// 未填写街道
		v("com.ksfc.newfarmer:id/choice_city_layout");
		solo.clickInList(1);
		s();
		solo.clickInList(getRandomInt(1, 12));
		s();
		solo.clickInList(getRandomInt(1, 5));
		s();
		v("com.ksfc.newfarmer:id/choice_compelet");
		if (!solo.waitForText("请完善信息")) {
			showErrLog(tag + ":newFarmer_business(): 未填写街道");
		}
		// 未填写详细地址
		v("com.ksfc.newfarmer:id/choice_town_layout");
		solo.clickInList(getRandomInt(1, 7));
		v("com.ksfc.newfarmer:id/choice_compelet");
		if (!solo.waitForText("请完善信息")) {
			showErrLog(tag + ":newFarmer_business():未填写详细地址");
		}
		// 重选地区看街道是否重置
		v("com.ksfc.newfarmer:id/choice_city_layout");
		solo.clickInList(1);
		s();
		solo.clickInList(getRandomInt(1, 12));
		s();
		solo.clickInList(getRandomInt(1, 5));
		s();
		if (!getTextHintString("com.ksfc.newfarmer:id/choice_town_text")
				.equals("选择所在街道或乡镇")) {
			showErrLog(tag + ":newFarmer_business():重选地区看街道是否重置");
		}
		//详细地址不能超过60位字符
		v("com.ksfc.newfarmer:id/choice_town_layout");
		solo.clickInList(getRandomInt(1, 7));
		enter("com.ksfc.newfarmer:id/store_address_tv",getRandomString(70));
		if(getEditTextString("com.ksfc.newfarmer:id/store_address_tv").length()!=60){
			showErrLog(tag + ":newFarmer_business():详细地址不能超过60位字符");
		}
		//填写格式错误的手机号
		v("com.ksfc.newfarmer:id/choice_compelet");
		if (!solo.waitForText("请检查手机号或者身份证号码是否正确")) {
			showErrLog(tag + ":newFarmer_business():填写格式错误的手机号");
		}
		//提交格式错误的身份证号
		clear("com.ksfc.newfarmer:id/phone_tv");
		enter("com.ksfc.newfarmer:id/phone_tv", Config.pNum_err);
		clear("com.ksfc.newfarmer:id/id_card_number_tv");
		enter("com.ksfc.newfarmer:id/id_card_number_tv", getRandomIntString(6));
		v("com.ksfc.newfarmer:id/choice_compelet");
		if (!solo.waitForText("请检查手机号或者身份证号码是否正确")) {
			showErrLog(tag + ":newFarmer_business():提交格式错误的身份证号");
		}
		/**
		 * 由于过程不可逆，为了方便多次测试，故不进行正确方式的保存
		 */
		g();
		g();
		t("首页");
	}
}