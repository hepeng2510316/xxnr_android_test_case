package com.example.yu.test.test;

import android.view.View;
import android.widget.EditText;
import com.example.yu.test.test.RunTestCase.BaseCase;
import com.example.yu.test.test.RunTestCase.Config;
import com.robotium.solo.Solo;

public class CaseCommodity extends BaseCase {
	public static String tag = "CaseCommodity";

	public static CaseCommodity caseInstance(Solo solo1) {
		CaseCommodity instance = new CaseCommodity();
		instance.instance(solo1);
		return instance;

	}

	// 商品详情页面
	public void test_commodityParticulars() {
		// 由专场进入商品详情页面
		logout();
		t("汽车专场");
		solo.clickInList(1);
		s();

		// 左右滚动商品图片信息
		View view = solo.getView("com.ksfc.newfarmer:id/imageView");
		dragView(view, 0.8f, 0.5f, 0.3f, 0.5f);
		dragView(view, 0.8f, 0.5f, 0.3f, 0.5f);
		dragView(view, 0.8f, 0.5f, 0.3f, 0.5f);

		// 点击放大图片
		solo.clickOnScreen(360, 500);
		g();

		// 向下活动进入商品描述
		solo.drag(460, 460, 900, 400, 3);
		solo.drag(460, 460, 900, 400, 3);

		// 切换商品详情描述
		solo.drag(460, 460, 900, 400, 3);
		t("详细参数");
		t("服务说明");

		// 商品数量的修改
		// 通过“+-”来修改商品数量
		t("加入购物车");
		for (int a = 0; a < 4; a++) {
			v("pop_discount_jia");
		}
		for (int b = 0; b < 4; b++) {
			v("pop_discount_jian");
		}

		// 商品数量为9999时继续增加
		clear("pop_discount_geshu");
		enter("pop_discount_geshu", "9999");
		v("pop_discount_jia");
		if (!solo.waitForText("商品数量不能大于9999")) {
			showErrLog(tag + ":commodityParticulars():商品数量为9999时继续增加");
		}

		// 商品数量为1时点击继续减少
		clear("pop_discount_geshu");
		enter("pop_discount_geshu", "1");
		v("pop_discount_jian");
		if (!solo.waitForText("商品数量不能再减少了")) {
			showErrLog(tag + ":commodityParticulars(): 商品数量为1时点击继续减少");
		}

		// 将商品数量改为0
		clear("pop_discount_geshu");
		enter("pop_discount_geshu", "0");
		EditText et2 = (EditText) solo.getView("pop_discount_geshu");
		String s2 = (String) et2.getText().toString();
		int a2 = Integer.parseInt(s2);
		if (a2 != 1) {
			showErrLog(tag + ":commodityParticulars():用数字键盘将商品数量改为0");
		}

		// 输入随机的正确的商品数量
		int x = 1 + (int) (Math.random() * 9999);
		String number = x + "";
		clear("pop_discount_geshu");
		enter("pop_discount_geshu", number);
		EditText et3 = (EditText) solo.getView("pop_discount_geshu");
		String s3 = (String) et3.getText().toString();
		int a3 = Integer.parseInt(s3);
		if (a3 != x) {
			showErrLog(tag + ":commodityParticulars():用数字键盘输入正确的商品数量");
		}

		// 未登录情况下商品属性未选择完全就加入购物车
		t("确定");
		if (!solo.waitForText("请选择商品信息")) {
			showErrLog(tag + "commodityParticulars():未登录情况下商品属性未选择完全就加入购物车");
		}

		// 未登录情况下选择完商品属性后加入购物车
		t("2.0T 自动（6DCT）");
		t("智能型");
		t("拉菲红");
		t("确定");
		if (!solo.waitForText("添加购物车成功")) {
			showErrLog(tag + "commodityParticulars():未登录情况下选择完商品属性后加入购物车");
		}

		// 登陆后商品属性未选择完就加入购物车
		g();
		g();
		login_sure(Config.pNum_reg);
		t("汽车专场");
		solo.clickInList(1);
		t("加入购物车");
		t("确定");
		if (!solo.waitForText("请选择商品信息")) {
			showErrLog(tag + "commodityParticulars():登陆后商品属性未选择完就加入购物车");
		}

		// 登陆后商品属性选择完并加入购物车
		t("2.0T 自动（6DCT）");
		t("智能型");
		t("拉菲红");
		t("确定");
		if (!solo.waitForText("添加购物车成功")) {
			showErrLog(tag + "commodityParticulars():未登录情况下选择完商品属性后加入购物车");
		}
		g();
		g();

		// 未登录立即购买
		logout();
		t("汽车专场");
		solo.clickInList(1);
		s();
		t("立即购买");
		t("确定");
		solo.assertCurrentActivity(
				tag + ":test_commodityParticulars():未登录立即购买", "LoginActivity");

		// 登录后商品属性未选择完全就立即购买
		clear("com.ksfc.newfarmer:id/login_layout_phone");
		enter(("com.ksfc.newfarmer:id/login_layout_phone"), Config.pNum_reg);//
		enter(("com.ksfc.newfarmer:id/login_layoutpassword"), Config.pwd_cur);
		t("确认登录");
		if (!solo.searchText("确定", 1, false, true)) {
			showErrLog(tag + "commodityParticulars():登录后商品属性未选择完全就立即购买");
		}
		t("确定");
		if (!solo.waitForText("请选择商品信息")) {
			showErrLog(tag + "commodityParticulars():登录后商品属性未选择完全就立即购买");
		}

		// 登陆后选择完商品属性后确认立即购买
		t("2.0T 自动（6DCT）");
		t("智能型");
		t("拉菲红");
		t("确定");
		if (!(solo.searchText("提交订单", 0, false, true))) {
			showErrLog(tag + "commodityParticulars():登陆后选择完商品属性后确认立即购买");
		}
		solo.goBackToActivity("HomepageActivity");
	}
}