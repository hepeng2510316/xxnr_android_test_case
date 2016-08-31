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

	// ����
	public void test_run() {
//		homePage();
		homePage_information();
	}
	/**
	 * ��ҳ
	 */
	public void homePage() {

		// δ��¼�����ǩ��
		Spoon.screenshot(getActivity(), "1");
		logout();
		v("com.ksfc.newfarmer:id/title_right_img");
		solo.assertCurrentActivity(tag + ":homePage():δ��¼�����ǩ��",
				"LoginActivity");
		g();
		// ��¼�����ǩ��
		login_sure(Config.pNum_reg);
		t("��ҳ");
		v("com.ksfc.newfarmer:id/title_right_img");
		if (!solo.searchText("ǩ���ɹ�", 1, false, true)) {
			if (!solo.waitForText("��������ǩ���ɹ������������ϣ�")) {
				showErrLog(tag + ":homePage(): ��¼�����ǩ��");
			}
		}
		v("com.ksfc.newfarmer:id/title_right_img");
		if (!solo.waitForText("��������ǩ���ɹ������������ϣ�")) {
			showErrLog(tag + ":homePage(): ��¼�����ǩ��");
		}
		// ��ҳ�ֲ������ת��
		View view = solo.getView("com.ksfc.newfarmer:id/iv");
		for (int a = 0; a < 4; a++) {
			dragView(view, 0.8f, 0.5f, 0.3f, 0.5f);
		}

		// ��ҳ���ҳ��֮�����ת
		// ��������ר��������
		v("com.ksfc.newfarmer:id/car_zhuanchang");
		solo.assertCurrentActivity(tag + ":homePage():��������ר��������",
				"GoodsListActivity");
		g();

		// ������ѡ-�����Ʒ��������ר��������
		v("com.ksfc.newfarmer:id/view_bar_more");
		solo.assertCurrentActivity(tag + ":homePage():������ѡ-�����Ʒ��������ר��������",
				"GoodsListActivity");
		g();
		// ����ר��������
		v("com.ksfc.newfarmer:id/huafei_zhuanchang");
		solo.assertCurrentActivity(tag + ":homePage():����ר��������",
				"GoodsListActivity");
		g();
		t("��Ѷ");
		solo.assertCurrentActivity(tag+":homePage():��Ѷ", "NewFarmerInfomationActivity");
		t("��ҳ");
		t("���ﳵ");
		solo.assertCurrentActivity(tag+":homePage():���ﳵ", "ShoppingCartActivity");
		t("��ҳ");
		t("�ҵ�");
		solo.assertCurrentActivity(tag+":homePage():�ҵ�", "MineActivity");
		t("��ҳ");
		v("com.ksfc.newfarmer:id/huafei_img");
		solo.assertCurrentActivity(tag+":homePage():��Ʒ����", "GoodsDetailActivity");
		g();// ����ĳ����Ʒ����Ʒ����ҳ��
	}

	/**
	 * ��Ѷ
	 */
	public void homePage_information() {
		t("��Ѷ");
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
		t("��ҳ");
	}
}
