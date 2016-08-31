package com.example.yu.test.test;

import android.view.View;
import com.example.yu.test.test.RunTestCase.*;
import com.robotium.solo.Solo;

public class CaseNewFarmer_myself extends BaseCase {

	public String tag = " CaseNewFarmer_myself";

	public static CaseNewFarmer_myself caseInstance(Solo solo1) {
		CaseNewFarmer_myself instance = new CaseNewFarmer_myself();
		instance.instance(solo1);
		return instance;
	}
	
	public void test_run(){
	//	newFarmer_information();
		newFarmer_password();
	}

	/**
	 * 个人信息
	 */
	public void newFarmer_information() {
		login_sure(Config.pNum_reg);
		t("我的");
		v("com.ksfc.newfarmer:id/head_View_bg");
		// 修改头像
		v("com.ksfc.newfarmer:id/header_image_ll");
		if (!solo.searchText("本地上传", 1, false, true)) {
			showErrLog(tag + ":newFarmer_information():修改头像");
		}
		t("取消");

		/**
		 * 修改昵称
		 */
		t("我的昵称");
		// 未修改昵称，保存按钮不可点击
		View view = solo.getView("com.ksfc.newfarmer:id/name_submit_tv");
		if (view.isEnabled()) {
			showErrLog(tag + ":newFarmer_information():未修改昵称，保存按钮不可点击");
		}
		// 在有昵称的前提下清空昵称保存
		clear("com.ksfc.newfarmer:id/et_modify");
		t("保存");
		if (!solo.waitForText("请您先完善信息")) {
			showErrLog(tag + ":newFarmer_information():在有昵称的前提下清空昵称");
		}
		// 修改昵称超过12位字符
		enter("com.ksfc.newfarmer:id/et_modify", getRandomString(16));
		String nicheng = getEditTextString("com.ksfc.newfarmer:id/et_modify");
		if (nicheng.length() != 12) {
			showErrLog(tag + ":newFarmer_information():修改昵称超过12位字符");
		}
		// 保存昵称
		t("保存");
		if (!solo.waitForText("保存成功")) {
			showErrLog(tag + ":newFarmer_information():保存昵称");
		}

		/**
		 * 修改姓名
		 */
		// 未修改姓名，保存按钮不可点击
		t("姓名");
		view = solo.getView("com.ksfc.newfarmer:id/name_submit_tv");
		if (view.isEnabled()) {
			showErrLog(tag + ":newFarmer_information():未修改姓名，保存按钮不可点击");
		}
		// 姓名为空时保存
		clear("com.ksfc.newfarmer:id/et_modify");
		t("保存");
		if (!solo.waitForText("请您先完善信息")) {
			showErrLog(tag + ":newFarmer_information(): 姓名为空时保存");
		}
		// 修改姓名超过12位字符
		enter("com.ksfc.newfarmer:id/et_modify", getRandomString(17));
		String name = getEditTextString("com.ksfc.newfarmer:id/et_modify");
		if (name.length() != 12) {
			showErrLog(tag + ":newFarmer_information():修改姓名超过12位字符");
		}
		// 保存姓名
		t("保存");
		if (!solo.waitForText("保存成功")) {
			showErrLog(tag + ":newFarmer_information():保存姓名");
		}

		/**
		 * 修改性别
		 */
		String sex = getTextViewString("com.ksfc.newfarmer:id/sex_tv");
		t("性别");
		// 取消选择性别
		v("com.ksfc.newfarmer:id/btn_cancel");
		String sex_change = getTextViewString("com.ksfc.newfarmer:id/sex_tv");
		if (!sex.equals(sex_change)) {
			showErrLog(tag + ":newFarmer_information():取消选择性别");
		}
		// 将性别修改为男
		t("性别");
		v("com.ksfc.newfarmer:id/btn_sure");
		if (!solo.waitForText("保存成功")) {
			showErrLog(tag + ":newFarmer_information():将性别修改为男");
		}
		sex_change = getTextViewString("com.ksfc.newfarmer:id/sex_tv");
		if (!sex_change.equals("男")) {
			showErrLog(tag + ":newFarmer_information():将性别修改为男");
		}
		// 将性别修改为女
		t("性别");
		v("com.ksfc.newfarmer:id/btn_normal");
		if (!solo.waitForText("保存成功")) {
			showErrLog(tag + ":newFarmer_information():将性别修改为女");
		}
		sex_change = getTextViewString("com.ksfc.newfarmer:id/sex_tv");
		if (!sex_change.equals("女")) {
			showErrLog(tag + ":newFarmer_information():将性别修改为女");
		}

		/**
		 * 用户所在地区
		 */
		// 未修地区，保存按钮不可点击
		t("所在地区");
		view = solo.getView("com.ksfc.newfarmer:id/name_submit_tv");
		if (view.isEnabled()) {
			showErrLog(tag + ":newFarmer_information():未修地区，保存按钮不可点击");
		}

		// 在已正确填写地址情况下修改地区，查看街道是否随之变化
		t("所在地区");
		v("com.ksfc.newfarmer:id/choice_city_layout");
		solo.clickInList(1);
		solo.clickInList(getRandomInt(1, 12));
		solo.clickInList(getRandomInt(1, 4));
		if (!getTextHintString("com.ksfc.newfarmer:id/choice_town_text")
				.equals("请选择街道")) {
			showErrLog(tag
					+ ":newFarmer_information():在已正确填写地址情况下修改地区，查看街道是否随之变化");
		}
		// 未填写街道情况下保存
		t("保存");
		if (!solo.waitForText("地址不能为空")) {
			showErrLog(tag + ":newFarmer_information():未填写街道情况下保存");
		}
		//正确保存地区
		v("com.ksfc.newfarmer:id/choice_town_layout");
		solo.clickInList(getRandomInt(1, 5));
		t("保存");
		if (!solo.waitForText("保存成功")) {
			showErrLog(tag + ":newFarmer_information():正确保存地区");
		}

		/**
		 * 更改用户类型
		 */
		//普通用户
		t("类型");
		t("普通用户");
		if (!solo.waitForText("保存成功")) {
			showErrLog(tag + ":newFarmer_information():普通用户");
		}
		if(!getTextViewString("com.ksfc.newfarmer:id/type_tv").equals("普通用户")){
			showErrLog(tag + ":newFarmer_information():普通用户");
		}
		//新农经纪人
		t("类型");
		t("新农经纪人");
		if (!solo.waitForText("保存成功")) {
			showErrLog(tag + ":newFarmer_information():新农经纪人");
		}
		if(!getTextViewString("com.ksfc.newfarmer:id/type_tv").equals("新农经纪人")){
			showErrLog(tag + ":newFarmer_information():新农经纪人");
		}
		//县级经销商
		t("类型");
		t("县级经销商");
		if (!solo.waitForText("保存成功")) {
			showErrLog(tag + ":newFarmer_information():县级经销商");
		}
		if(!getTextViewString("com.ksfc.newfarmer:id/type_tv").equals("县级经销商")){
			showErrLog(tag + ":newFarmer_information():县级经销商");
		}
		//已申请认证的县级经销商可以查看认证信息
		if(!solo.searchText("查看认证信息")){
			showErrLog(tag + ":newFarmer_information():已申请认证的县级经销商可以查看认证信息");
		}
		//查看认证信息
		v("com.ksfc.newfarmer:id/choose_type_Certified_ll");
		if(!solo.searchText("详细地址")){
			showErrLog(tag + ":newFarmer_information():查看认证信息");
		}
		g();
		//未申请县级网点认证的账户
		t("退出登录");
		solo.clickOnButton("确定");
		t("首页");
		login_sure(Config.pNum_null);
		t("我的");
		v("com.ksfc.newfarmer:id/head_View_bg");
		if(!solo.searchText("想成为新新农人的县级网点？去申请认证吧")){
			showErrLog(tag + ":newFarmer_information():未申请县级网点认证的账户");
		}
		//进入服务站认证页面
		v("com.ksfc.newfarmer:id/choose_type_Certified_ll");
		if(!solo.searchText("服务站认证")){
			showErrLog(tag + ":newFarmer_information():进入服务站认证页面");
		}
		g();
		g();
	}

	/**
	 * 修改密码
	 */

	public void newFarmer_password() {
	//	login_sure(Config.pNum_reg);
		t("我的");
		v("com.ksfc.newfarmer:id/head_View_bg");
		t("修改密码");
		// 未输入任何密码
		t("完成");
		if (!solo.waitForText("请输入旧密码")) {
			showErrLog(tag + ":newFarmer_password():未输入任何密码");
		}
		// 只输入旧密码
		enter("com.ksfc.newfarmer:id/backedit1",Config.pwd_err);
		t("完成");
		if (!solo.waitForText("请输入新密码")) {
			showErrLog(tag + ":newFarmer_password():只输入旧密码");
		}
		// 未输入确认密码
		enter("com.ksfc.newfarmer:id/backnewpassword", Config.pwd_cur);
		t("完成");
		if (!solo.waitForText("请输入确认密码")) {
			showErrLog(tag + ":newFarmer_password():未输入确认密码");
		}
		// 输入错误的旧密码
		enter("com.ksfc.newfarmer:id/confimPasword", Config.pwd_cur);
		t("完成");
		if (!solo.waitForText("旧密码输入错误")) {
			showErrLog(tag + ":newFarmer_password():输入错误的旧密码");
		}
		// 输入的新旧密码一致
		clear("com.ksfc.newfarmer:id/backedit1");
		enter("com.ksfc.newfarmer:id/backedit1", Config.pwd_cur);
		t("完成");
		if (!solo.waitForText("新密码与旧密码不能一致")) {
			showErrLog(tag + ":newFarmer_password():输入的新旧密码一致");
		}
		// 新密码和确认密码不一致
		clear("com.ksfc.newfarmer:id/backnewpassword");
		enter("com.ksfc.newfarmer:id/backnewpassword", Config.pwd_err);
		t("完成");
		if (!solo.waitForText("两次密码不一致，请重新输入")) {
			showErrLog(tag + ":newFarmer_password(): 新密码和确认密码不一致");
		}
		//新密码与确认密码小于6位
		clear("com.ksfc.newfarmer:id/confimPasword");
		enter("com.ksfc.newfarmer:id/confimPasword", Config.pwd_err);
		t("完成");
		if (!solo.waitForText("密码需不小于6位")) {
			showErrLog(tag + ":newFarmer_password(): 新密码与确认密码小于6位");
		}
		//修改密码成功
		clear("com.ksfc.newfarmer:id/backnewpassword");
		enter("com.ksfc.newfarmer:id/backnewpassword", Config.new_pwd);
		clear("com.ksfc.newfarmer:id/confimPasword");
		enter("com.ksfc.newfarmer:id/confimPasword", Config.new_pwd);
		t("完成");
		if (!solo.waitForText("修改密码成功")) {
			showErrLog(tag + ":newFarmer_password(): 修改密码成功");
		}
		//改回原密码，方便下次测试
		clear("com.ksfc.newfarmer:id/login_layout_phone");
		enter("com.ksfc.newfarmer:id/login_layout_phone",Config.pNum_reg);
		enter("com.ksfc.newfarmer:id/login_layoutpassword",Config.new_pwd);
		t("确认登录");
		v("com.ksfc.newfarmer:id/head_View_bg");
		t("修改密码");
		enter("com.ksfc.newfarmer:id/backedit1",Config.new_pwd);
		enter("com.ksfc.newfarmer:id/backnewpassword", Config.pwd_cur);
		enter("com.ksfc.newfarmer:id/confimPasword", Config.pwd_cur);
		t("完成");
	}

	
}