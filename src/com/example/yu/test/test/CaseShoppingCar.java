package com.example.yu.test.test;

import java.util.ArrayList;

import android.view.View;
import android.widget.TextView;

import com.example.yu.test.test.RunTestCase.*;
import com.robotium.solo.Solo;

public class CaseShoppingCar extends BaseCase {

	String tag = "CaseShoppingCar";

	public static CaseShoppingCar caseInstance(Solo solo1) {
		CaseShoppingCar instance = new CaseShoppingCar();
		instance.instance(solo1);
		return instance;
	}
	
	public void test_run() {
		shoppingCar_jump();
		shoppingCar_number();
		shoppingCar_delete();
		toClearing() ;
	}


	// 往购物车内添加商品并返回购物车
	public void add() {
		t("首页");
		t("汽车专场");
		solo.clickInList(1);
		s();
		t("加入购物车");
		t("1.5L 手动（MT）");
		t("豪华型");
		t("炫酷黑");
		t("确定");
		t("加入购物车");
		t("雅致棕");
		t("确定");
		t("加入购物车");
		t("拉菲红");
		t("确定");
		t("加入购物车");
		t("典雅白");
		t("确定");
		g();
		solo.clickInList(2);
		t("加入购物车");
		t("确定");
		g();
		g();
		t("化肥专场");
		solo.clickInList(2);
		t("加入购物车");
		t("确定");
		v("com.ksfc.newfarmer:id/title_right_img");
	}

	/**
	 * 购物车页面的跳转
	 */
	public void shoppingCar_jump() {

		// 保证购物车为空
		t("购物车");
		if (!solo.searchText("去买化肥",1,false,true)) {
			t("编辑");
			v("com.ksfc.newfarmer:id/btn_check_all");
			v("com.ksfc.newfarmer:id/ordering_go_bt");
			solo.clickOnButton("是");
		}
		t("首页");
		solo.assertCurrentActivity(tag + ":shoppingCar_jump():首页",
				"HomepageActivity");
		t("购物车");
		t("资讯");
		solo.assertCurrentActivity(tag + ":shoppingCar_jump():资讯",
				"NewFarmerInfomationActivity");
		t("购物车");
		t("我的");
		solo.assertCurrentActivity(tag + ":shoppingCar_jump():我的",
				"MineActivity");
		t("购物车");
		t("去买化肥");
		solo.assertCurrentActivity(tag + ":shoppingCar_jump():化肥专场",
				"GoodsListActivity");
		g();
		t("去买汽车");
		solo.assertCurrentActivity(tag + ":shoppingCar_jump():汽车专场",
				"GoodsListActivity");
		g();
	}

	/**
	 * 修改商品数量 (由于需要较多的商品，但商品属性暂时无法通过代码随机正确选择，所以用add()写死了加入购物车的商品及其属性)
	 */
	public void shoppingCar_number() {
		// 向购物车中添加写死的商品
		add();

		// 商品数量的修改
		// 通过“+-”来修改商品数量
		for (int a = 0; a < 4; a++) {
			v("com.ksfc.newfarmer:id/ordering_item_jia1");
		}
		for (int b = 0; b < 4; b++) {
			v("com.ksfc.newfarmer:id/ordering_item_jian1");
		}

		// 将商品数量删除
		v("com.ksfc.newfarmer:id/ordering_item_geshu");
		clear("com.ksfc.newfarmer:id/dialog_item_geshu");
		t("确定");
/**		if (!solo.waitForText("请输入正确的商品数量呦")) {
 *			showErrLog(tag + ":shoppingCar_number():将商品数量删除");
 *		}
*/
		// 将商品数量改为0
		clear("com.ksfc.newfarmer:id/dialog_item_geshu");
		enter("com.ksfc.newfarmer:id/dialog_item_geshu", "0");
		t("确定");
/**		if (!solo.searchText("请输入正确的商品数量呦")) {
 *			showErrLog(tag + ":shoppingCar_number():将商品数量改为0");
 *		}
 */
		// 输入随机的正确的商品数量
		int x = 1 + (int) (Math.random() * 9999);
		String number = x + "";
		clear("com.ksfc.newfarmer:id/dialog_item_geshu");
		enter("com.ksfc.newfarmer:id/dialog_item_geshu", number);
		t("确定");
		TextView tv = (TextView) solo
				.getView("com.ksfc.newfarmer:id/ordering_item_geshu");
		String s = (String) tv.getText();
		int a = Integer.parseInt(s);
		if (a != x) {
			showErrLog(tag + ":shoppingCar_number():用数字键盘输入正确的商品数量");
		}

		// 商品数量为1时点击继续减少
		v("com.ksfc.newfarmer:id/ordering_item_geshu");
		clear("com.ksfc.newfarmer:id/dialog_item_geshu");
		enter("com.ksfc.newfarmer:id/dialog_item_geshu", "1");
		t("确定");
		v("ordering_item_jian1");
		if (!solo.waitForText("商品不能再减少了哦")) {
			showErrLog(tag + ":shoppingCar_number(): 商品数量为1时点击继续减少");
		}

		// 商品数量为9999时继续增加
		v("com.ksfc.newfarmer:id/ordering_item_geshu");
		clear("com.ksfc.newfarmer:id/dialog_item_geshu");
		enter("com.ksfc.newfarmer:id/dialog_item_geshu", "9999");
		t("确定");
		v("ordering_item_jia1");
		if (!solo.waitForText("商品数量不能大于9999")) {
			showErrLog(tag + ":shoppingCar_number():商品数量为9999时继续增加");
		}
	}

	/**
	 * 删除商品
	 */
	public void shoppingCar_delete() {
		// 向左滑动删除某个商品
		if (solo.searchText("完成", 1, false, true)) {
			t("完成");
		}
		View view = solo.getView("com.ksfc.newfarmer:id/ordering_item_img");
		dragView(view, 0.8f, 0.5f, 0.3f, 0.5f);
		if (!solo.searchText("删除", 1, false, true)) {
			showErrLog(tag + ":shoppingCar_delete():向左滑动删除某个商品");
		}
		t("删除");
		t("是");

		// 通过编辑批量删除商品
		// 通过取消全选，在没有选中任何商品的情况下删除
		t("编辑");
		ArrayList<android.widget.CheckBox> checkBox = solo
				.getCurrentViews(android.widget.CheckBox.class);
		int a = (checkBox.size() - 1);
		if (solo.isCheckBoxChecked(0)) {
			solo.clickOnCheckBox(0);
		}
		solo.clickOnCheckBox(a);
		solo.clickOnCheckBox(a);
		v("com.ksfc.newfarmer:id/ordering_go_bt");
		if (!solo.waitForText("请您至少选择一件商品")) {
			showErrLog(tag + ":shoppingCar_delete():通过取消全选，在没有选中任何商品的情况下删除");
		}

		// 随机选择删除部分商品
		int x = (int) (Math.random() * a);
		solo.clickOnView(checkBox.get(x));
		v("com.ksfc.newfarmer:id/ordering_go_bt");
		t("是");
		t("首页");
	}

	/**
	 * 购物车页面的去结算操作
	 */

	public void toClearing() {
		logout();
		t("购物车");
		// 判断购物车内还有没有商品没有则添加
		if (solo.searchText("去买化肥", 1, false, true)) {
			add();
		} else {
			t("完成");
		}

		// 未登录且未选择任何商品的情况下选择去结算
		v("com.ksfc.newfarmer:id/ordering_go_bt");
		solo.assertCurrentActivity(tag + ":toClearing():未登录情况下选择商品去结算",
				"LoginActivity");
		g();

		// 未登录情况下选择商品去结算
		solo.clickOnCheckBox(0);
		v("com.ksfc.newfarmer:id/ordering_go_bt");
		solo.assertCurrentActivity(tag + ":toClearing():未登录情况下选择商品去结算",
				"LoginActivity");
		// 登录情况下未选择任何商品去结算
		clear("com.ksfc.newfarmer:id/login_layout_phone");
		enter(("com.ksfc.newfarmer:id/login_layout_phone"), Config.pNum_reg);//
		enter(("com.ksfc.newfarmer:id/login_layoutpassword"), Config.pwd_cur);
		t("确认登录");
		v("com.ksfc.newfarmer:id/ordering_go_bt");
		if (!solo.waitForText("请您至少选择一件商品")) {
			showErrLog(tag + ":shoppingCar_delete():登录情况下未选择任何商品去结算");
		}

		// 登陆后选择一件商品去结算
		if (solo.searchText("去买化肥", 1, false, true)) {
			add();
		}
		ArrayList<android.widget.CheckBox> checkBox2 = solo
				.getCurrentViews(android.widget.CheckBox.class);
		int a = (checkBox2.size() - 1);
		solo.clickOnView(checkBox2.get(1));
		v("com.ksfc.newfarmer:id/ordering_go_bt");
		solo.assertCurrentActivity(tag + ":toClearing():登陆后选择一件商品去结算",
				"AddOrderActivity");
		g();

		// 登陆后选择全部商品去结算
		solo.clickOnView(checkBox2.get(a));
		v("com.ksfc.newfarmer:id/ordering_go_bt");
		solo.assertCurrentActivity(tag + ":toClearing():登陆后选择全部商品去结算",
				"AddOrderActivity");
		
	}

}
