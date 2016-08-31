package com.example.yu.test.test;

import com.example.yu.test.test.RunTestCase.*;
import com.robotium.solo.Solo;

public class CaseMyNewFarmer extends BaseCase {

	public String tag = " CaseMyNewFarmer";

	public static CaseMyNewFarmer caseInstance(Solo solo1) {
		CaseMyNewFarmer instance = new CaseMyNewFarmer();
		instance.instance(solo1);
		return instance;
	}

	public void test_run() {
		newFarmer_jump();
		setting();
	}

	/**
	 * 我的页面与其他页面之间的跳转
	 */
	public void newFarmer_jump() {
		/**
		 * 未登录状态下的跳转
		 */
		logout();
		t("我的");
		// 未登录状态下不展示我的网点
		if (solo.searchText("我的网点", 1, false, true)) {
			showErrLog(tag + ":newFarmer_jump():未登录状态下不展示我的网点");
		}
		// 未登录状态各页面的跳转
		v("com.ksfc.newfarmer:id/head_View");
		solo.assertCurrentActivity(tag + "newFarmer_jump():登录页面",
				"LoginActivity");
		g();
		t("我的订单");
		solo.assertCurrentActivity(tag + "newFarmer_jump():我的订单",
				"LoginActivity");
		g();
		t("积分商城");
		if (!solo.searchText("兑换记录", 1, false, true)) {
			showErrLog(tag + ":newFarmer_jump():积分商城");
		}
		g();
		t("新农代表");
		solo.assertCurrentActivity(tag + "newFarmer_jump():新农代表",
				"LoginActivity");
		g();
		t("客服电话");
		if (!solo.searchText("拨打", 1, false, true)) {
			showErrLog(tag + ":newFarmer_jump():客服电话");
		}
		t("取消");
		t("设置");
		solo.assertCurrentActivity(tag + "newFarmer_jump():设置",
				"SettingActivity");
		g();
		t("首页");
		solo.assertCurrentActivity(tag + "newFarmer_jump():首页",
				"HomepageActivity");
		t("我的");
		t("购物车");
		solo.assertCurrentActivity(tag + "newFarmer_jump():购物车",
				"ShoppingCartActivity");
		t("我的");
		t("资讯");
		solo.assertCurrentActivity(tag + "newFarmer_jump():资讯",
				"NewFarmerInfomationActivity");
		t("首页");
		
		/**
		 * 登录状态下的跳转
		 */
		login_sure(Config.pNum_reg);
		t("我的");
		v("com.ksfc.newfarmer:id/head_View");
		if (!solo.searchText("我的头像", 1, false, true)) {
			showErrLog(tag + ":newFarmer_jump():个人信息");
		}
		g();
		t("我的订单");
		if (!solo.searchText("我的订单", 1, false, true)) {
			showErrLog(tag + ":newFarmer_jump():我的订单");
		}
		g();
		t("积分商城");
		if (!solo.searchText("兑换记录", 1, false, true)) {
			showErrLog(tag + ":newFarmer_jump():登陆后的积分商城");
		}
		g();
		t("新农代表");
		if (!solo.searchText("我的代表", 1, false, true)) {
			showErrLog(tag + ":newFarmer_jump():登陆后的新农代表");
		}
		g();
		t("客服电话");
		if (!solo.searchText("拨打", 1, false, true)) {
			showErrLog(tag + ":newFarmer_jump():客服电话");
		}
		t("取消");
		t("设置");
		solo.assertCurrentActivity(tag + "newFarmer_jump():登陆后的设置",
				"SettingActivity");
		g();
		t("首页");
		solo.assertCurrentActivity(tag + "newFarmer_jump():登陆后的首页",
				"HomepageActivity");
		t("我的");
		t("购物车");
		solo.assertCurrentActivity(tag + "newFarmer_jump():登陆后的购物车",
				"ShoppingCartActivity");
		t("我的");
		t("资讯");
		solo.assertCurrentActivity(tag + "newFarmer_jump():登陆后的资讯",
				"NewFarmerInfomationActivity");
		t("我的");
	}

	/**
	 * 设置页面
	 */
	public void setting() {
		t("设置");
		// 关闭消息通知
		if (solo.isCheckBoxChecked(0)) {
			solo.clickOnCheckBox(0);
			if (!solo.searchText("确定", 1, false, true)) {
				showErrLog(tag + ":setting():关闭消息通知");
			}
			solo.clickOnButton("确定");
			s();
		}
		solo.clickOnCheckBox(0);
		s();
		// 清除缓存
		t("清除缓存");
		if (!solo.searchText("确定", 1, false, true)) {
			showErrLog(tag + ":setting():清除缓存");
		}
		solo.clickOnButton("确定");
		solo.sleep(1000);
		if (!solo.waitForText("缓存已经清理干净了！")) {
			showErrLog(tag + ":setting():确定清除缓存");
		}
		// 版本更新不是最新版本
		t("版本更新");
		if (solo.searchText("暂不升级", 1, false, true)) {
			t("暂不升级");
			t("版本升级");
			t("立即升级");
		} else {
			t("版本更新");
			if (!solo.waitForText("最新版本")) {
				showErrLog(tag + ":setting():版本是最新版本");
			}
		}
		// 推荐新新农人给好友
		t("推荐新新农人给好友");
		if (!solo.searchText("分享到", 1, false, true)) {
			showErrLog(tag + ":setting():推荐新新农人给好友");
		}
		g();
		// 关于
		t("关于");
		if (!solo.searchText("关于我们", 1, false, true)) {
			showErrLog(tag + ":setting():关于");
		}
		g();
	}
}
