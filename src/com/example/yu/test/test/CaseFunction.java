package com.example.yu.test.test;

import com.example.yu.test.test.RunTestCase.*;
import com.robotium.solo.Solo;

public class CaseFunction extends BaseCase {

	public String tag = " CaseFunction";

	public static CaseFunction caseInstance(Solo solo1) {
		CaseFunction instance = new CaseFunction();
		instance.instance(solo1);
		return instance;
	}

	// 运行
	public void test_run() {
		register();
		loginTest();
		forgetPassword();
	}

	/**
	 * 注册页面
	 */
	public void register() {
		// 进入注册界面
		login();
		t("立即注册");
		// 未填写手机号
		t("立即注册");
		if (!solo.waitForText("请输入手机号")) {
			showErrLog(tag + ":register() :未填写手机号");
		}

		// 已注册的手机号
		enter(("com.ksfc.newfarmer:id/backedit1"), Config.pNum_reg);
		t("免费获取验证码");
		if (!solo.waitForText("该手机号已注册，请重新输入")) {
			showErrLog(tag + ":register() :已注册的手机号");
		}

		// 格式错误的手机号
		clear(("com.ksfc.newfarmer:id/backedit1"));
		enter(("com.ksfc.newfarmer:id/backedit1"), Config.pNum_err);
		t("免费获取验证码");
		if (!solo.waitForText("请输入正确的手机号")) {
			showErrLog(tag + ":register() :格式错误的手机号");
		}
		// 需要填写图形验证码，弹出图形验证码窗口
		clear(("com.ksfc.newfarmer:id/backedit1"));
		enter(("com.ksfc.newfarmer:id/backedit1"), Config.pNum_unReg);
		v("com.ksfc.newfarmer:id/backgetVerificationCode");
		if (!solo.searchText("安全验证", true)) {
			g();
			t("忘记密码？");
			enter(("com.ksfc.newfarmer:id/backedit1"), Config.pNum_reg);
			v("com.ksfc.newfarmer:id/backgetVerificationCode");
		}
		if (!solo.searchText("安全验证", true)) {
			showErrLog(tag + ": register():需要填写图形验证码，弹出图形验证码窗口");
		}
		// 没有填写图形验证码
		solo.clickOnButton("确定");
		if (!solo.searchText("请输入图形验证码", true)) {
			showErrLog(tag + ":register() :没有填写图形验证码");
		}
		// 图形验证码错误
		enter("com.ksfc.newfarmer:id/sms_auth_code_et", "123");
		solo.clickOnButton("确定");
		if (!solo.searchText("图形验证码错误", true)) {
			showErrLog(tag + ":register() :图形验证码错误");
		}
		solo.clickOnButton("取消");
		// 未填写验证码
		t("立即注册");
		if (!solo.waitForText("请输入验证码")) {
			showErrLog(tag + ":register() :未填写验证码");
		}
		// 未填写密码
		enter(("com.ksfc.newfarmer:id/backyanzhengma"), "1111");
		t("立即注册");
		if (!solo.waitForText("请输入密码")) {
			showErrLog(tag + ":register() :未填写密码");
		}
		// 未填写确认密码
		enter(("com.ksfc.newfarmer:id/backnewpassword"), "11111");// 输入的是5位错误密码
		t("立即注册");
		if (!solo.waitForText("请输入确认密码")) {
			showErrLog(tag + ":register() :未填写确认密码");
		}
		// 密码和确认密码低于六位
		enter(("com.ksfc.newfarmer:id/confimPasword"), "11111");// 输入的是5位错误确认密码
		t("立即注册");
		if (!solo.waitForText("密码长度不小于6位")) {
			showErrLog(tag + ":register() :密码和确认密码低于六位");
		}
		// 密码与确认密码不一致
		clear("com.ksfc.newfarmer:id/backnewpassword");
		enter(("com.ksfc.newfarmer:id/backnewpassword"), Config.pwd_cur);// 输入的是正确的6位密码
		t("立即注册");
		if (!solo.waitForText("两次密码不一致，请重新输入")) {
			showErrLog(tag + ":register() :密码与确认密码不一致");
		}
		// 未勾选用户协议
		clear(("com.ksfc.newfarmer:id/confimPasword"));
		enter(("com.ksfc.newfarmer:id/confimPasword"), Config.pwd_cur);
		if (solo.isCheckBoxChecked(0)) {
			v("com.ksfc.newfarmer:id/check_box");
		}
		t("立即注册");
		if (!solo.waitForText("请同意网站使用协议")) {
			showErrLog(tag + ":register() :未勾选用户协议");
		}
		// 查看用户协议
		v("com.ksfc.newfarmer:id/register_layoutxieyi");
		g();
		// 验证码错误或没有查找到验证码
		v("com.ksfc.newfarmer:id/check_box");
		t("立即注册");
		boolean a = solo.waitForText("验证码输入错误");
		boolean b = solo.waitForText("没有查找到验证码");
		if (!(a | b)) {
			showErrLog(tag + ":register() :验证码错误或没有查找到验证码");
		}

		// 跳转登录页面
		t("登录");
		solo.assertCurrentActivity(tag + ":register(): 跳转登录页面", "LoginActivity");
		g();
		t("首页");
	}

	// 登录测试
	public void loginTest() {
		login();
		// 登录页面与其它页面的跳转
		t("忘记密码？");
		solo.assertCurrentActivity(tag + "testLogin():登录页面与其它页面的跳转",
				"RetrievePasswordActivity");
		g();
		t("立即注册");
		solo.assertCurrentActivity(tag + "testLogin():登录页面与其它页面的跳转",
				"RegisterActivity");
		g();
		g();
		t("首页");
		// 登录个人资料不完善的账户
		login_sure(Config.pNum_null);
		solo.assertCurrentActivity(tag + ":testLogin():登录个人资料不完善的账户",
				"ImprovePersonActivity");
		// 未输入手机号
		login();
		clear(("com.ksfc.newfarmer:id/login_layout_phone"));
		t("确认登录");
		if (!solo.waitForText("请输入手机号")) {
			showErrLog(tag + ":loginTest():未输入手机号");
		}
		// 格式错误的手机号
		enter(("com.ksfc.newfarmer:id/login_layout_phone"), Config.pNum_err);
		t("确认登录");
		if (!solo.waitForText("请输入正确的手机号")) {
			showErrLog(tag + ":loginTest():格式错误的手机号");
		}
		// 输入未注册的手机号
		clear(("com.ksfc.newfarmer:id/login_layout_phone"));
		enter(("com.ksfc.newfarmer:id/login_layout_phone"), Config.pNum_unReg);
		enter("com.ksfc.newfarmer:id/login_layoutpassword", Config.pwd_cur);
		t("确认登录");
		if (!solo.waitForText("该手机号未注册，请重新输入")) {
			showErrLog(tag + ":loginTest():输入未注册的手机号");
		}

		// 未输入密码
		clear(("com.ksfc.newfarmer:id/login_layout_phone"));
		enter(("com.ksfc.newfarmer:id/login_layout_phone"), Config.pNum_reg);
		clear("com.ksfc.newfarmer:id/login_layoutpassword");
		t("确认登录");
		if (!solo.waitForText("请输入密码")) {
			showErrLog(tag + ":loginTest():未输入密码");
		}

		// 输入错误密码
		enter(("com.ksfc.newfarmer:id/login_layoutpassword"), Config.pwd_err);
		t("确认登录");
		if (!solo.waitForText("密码错误，请重新输入")) {
			showErrLog(tag + ":loginTest():输入错误密码");
		}

		// 只输入密码
		clear("com.ksfc.newfarmer:id/login_layout_phone");
		t("确认登录");
		if (!solo.waitForText("请输入手机号")) {
			showErrLog(tag + ":loginTest():只输入密码");
		}

		// 登录个人资料完善的账户
		clear("com.ksfc.newfarmer:id/login_layout_phone");
		enter("com.ksfc.newfarmer:id/login_layout_phone", Config.pNum_reg);
		clear("com.ksfc.newfarmer:id/login_layoutpassword");
		enter(("com.ksfc.newfarmer:id/login_layoutpassword"), Config.pwd_cur);
		t("确认登录");
		solo.assertCurrentActivity(tag + ":testLogin():登录个人资料完善的账户",
				"MineActivity");
		t("首页");
	}

	// 忘记密码页面
	public void forgetPassword() {
		// 进入忘记密码页面
		login();
		t("忘记密码？");
		// 未填写手机号
		t("完成");
		if (!solo.waitForText("请输入手机号")) {
			showErrLog(tag + ": forgetPassword():未填写手机号");
		}
		// 格式错误的手机号
		enter(("com.ksfc.newfarmer:id/backedit1"), Config.pNum_err);
		v("com.ksfc.newfarmer:id/backgetVerificationCode");
		if (!solo.waitForText("请输入正确的手机号")) {
			showErrLog(tag + ": forgetPassword():格式错误的手机号");
		}
		// 未注册的手机号
		clear("com.ksfc.newfarmer:id/backedit1");
		enter(("com.ksfc.newfarmer:id/backedit1"), Config.pNum_unReg);
		v("com.ksfc.newfarmer:id/backgetVerificationCode");
		if (!solo.waitForText("该手机号未注册，请重新输入")) {
			showErrLog(tag + ": forgetPassword():未注册的手机号");
		}

		// 连续两次申请短信验证码，出现图片验证码
		clear("com.ksfc.newfarmer:id/backedit1");
		enter(("com.ksfc.newfarmer:id/backedit1"), Config.pNum_reg);
		v("com.ksfc.newfarmer:id/backgetVerificationCode");
		if (!solo.searchText("安全验证", true)) {
			g();
			t("忘记密码？");
			enter(("com.ksfc.newfarmer:id/backedit1"), Config.pNum_reg);
			v("com.ksfc.newfarmer:id/backgetVerificationCode");
		}
		if (!solo.searchText("安全验证", true)) {
			showErrLog(tag + ": forgetPassword():连续两次申请短信验证码，出现图片验证码");
		}
		// 没有填写图形验证码
		solo.clickOnButton("确定");
		if (!solo.searchText("请输入图形验证码", true)) {
			showErrLog(tag + ":forgetPassword() :没有填写图形验证码");
		}
		// 图形验证码错误
		enter("com.ksfc.newfarmer:id/sms_auth_code_et", "123");
		solo.clickOnButton("确定");
		if (!solo.searchText("图形验证码错误", true)) {
			showErrLog(tag + ":forgetPassword() :图形验证码错误");
		}
		solo.clickOnButton("取消");

		// 未填写验证码
		t("完成");
		if (!solo.waitForText("请输入验证码")) {
			showErrLog(tag + ": forgetPassword():未填写验证码");
		}

		// 未填写新密码
		enter(("com.ksfc.newfarmer:id/backyanzhengma"), "1111");// 输入的是错误的验证码
		t("完成");
		if (!solo.waitForText("请输入密码")) {
			showErrLog(tag + ": forgetPassword():未填写新密码");
		}

		// 未填写确认密码
		enter(("com.ksfc.newfarmer:id/backnewpassword"), Config.pwd_err);
		t("完成");
		if (!solo.waitForText("请输入确认密码")) {
			showErrLog(tag + ": forgetPassword():未填写确认密码");
		}

		// 密码与确认密码格式不正确小于六位
		enter(("com.ksfc.newfarmer:id/confimPasword"), Config.pwd_err);
		t("完成");
		if (!solo.waitForText("密码长度不小于6位")) {
			showErrLog(tag + ": forgetPassword():密码与确认密码格式不正确小于六位");
		}

		// 密码与确认密码不一致
		clear("com.ksfc.newfarmer:id/backnewpassword");
		enter(("com.ksfc.newfarmer:id/backnewpassword"), Config.pwd_cur);// 将密码改为正确的密码
		t("完成");
		if (!solo.waitForText("两次密码输入不一致，请重新输入")) {
			showErrLog(tag + ": forgetPassword(): 密码与确认密码不一致");
		}

		// 验证码错误
		clear("com.ksfc.newfarmer:id/confimPasword");
		enter(("com.ksfc.newfarmer:id/confimPasword"), Config.pwd_cur);
		t("完成");
		boolean a = solo.waitForText("验证码输入错误");
		boolean b = solo.waitForText("验证码已过期，请重新获取");
		if (!(a|b)) {
			showErrLog(tag + ": forgetPassword():验证码错误");
		}
		g();
		g();// 返回到我的页面
	}
}
