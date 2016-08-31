package com.example.yu.test.test;

import android.view.View;
import com.example.yu.test.test.RunTestCase.*;
import com.robotium.solo.Solo;
import com.squareup.spoon.Spoon;

public class CaseHomePage extends BaseCase {
	public static String tag = "CaseHomePage";

	public static CaseHomePage caseInstance(Solo solo1) {
		CaseHomePage instance = new CaseHomePage();
		instance.instance(solo1);
		return instance;
	}

	// 运行
	public void test_run() {
//		homePage();
		homePage_information();
	}
	/**
	 * 首页
	 */
	public void homePage() {

		// 未登录情况下签到
		Spoon.screenshot(getActivity(), "1");
		logout();
		v("com.ksfc.newfarmer:id/title_right_img");
		solo.assertCurrentActivity(tag + ":homePage():未登录情况下签到",
				"LoginActivity");
		g();
		// 登录情况下签到
		login_sure(Config.pNum_reg);
		t("首页");
		v("com.ksfc.newfarmer:id/title_right_img");
		if (!solo.searchText("签到成功", 1, false, true)) {
			if (!solo.waitForText("您今日已签到成功，明天再来呦！")) {
				showErrLog(tag + ":homePage(): 登录情况下签到");
			}
		}
		v("com.ksfc.newfarmer:id/title_right_img");
		if (!solo.waitForText("您今日已签到成功，明天再来呦！")) {
			showErrLog(tag + ":homePage(): 登录情况下签到");
		}
		// 首页轮播画面的转换
		View view = solo.getView("com.ksfc.newfarmer:id/iv");
		for (int a = 0; a < 4; a++) {
			dragView(view, 0.8f, 0.5f, 0.3f, 0.5f);
		}

		// 首页与各页面之间的跳转
		// 进入汽车专场并返回
		v("com.ksfc.newfarmer:id/car_zhuanchang");
		solo.assertCurrentActivity(tag + ":homePage():进入汽车专场并返回",
				"GoodsListActivity");
		g();

		// 汽车精选-跟多产品进入汽车专场并返回
		v("com.ksfc.newfarmer:id/view_bar_more");
		solo.assertCurrentActivity(tag + ":homePage():汽车精选-跟多产品进入汽车专场并返回",
				"GoodsListActivity");
		g();
		// 化肥专场并返回
		v("com.ksfc.newfarmer:id/huafei_zhuanchang");
		solo.assertCurrentActivity(tag + ":homePage():化肥专场并返回",
				"GoodsListActivity");
		g();
		t("资讯");
		solo.assertCurrentActivity(tag+":homePage():资讯", "NewFarmerInfomationActivity");
		t("首页");
		t("购物车");
		solo.assertCurrentActivity(tag+":homePage():购物车", "ShoppingCartActivity");
		t("首页");
		t("我的");
		solo.assertCurrentActivity(tag+":homePage():我的", "MineActivity");
		t("首页");
		v("com.ksfc.newfarmer:id/huafei_img");
		solo.assertCurrentActivity(tag+":homePage():商品详情", "GoodsDetailActivity");
		g();// 任意某个商品的商品详情页面
	}

	/**
	 * 资讯
	 */
	public void homePage_information() {
		t("资讯");
		for (int a = 0; a < 3; a++) {
			int x = (int) (Math.random() * 5);
			solo.clickInList(x);
			solo.assertCurrentActivity(tag+":homePage_information()", "ArticleActivity");
			g();
		}
		int x = (int) (Math.random() * 5);
		solo.clickInList(x);
		v("com.ksfc.newfarmer:id/title_right_img");
		g();
		g();
		t("首页");
	}
}
