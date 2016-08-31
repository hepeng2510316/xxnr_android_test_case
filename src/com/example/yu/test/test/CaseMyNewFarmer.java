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
	 * �ҵ�ҳ��������ҳ��֮�����ת
	 */
	public void newFarmer_jump() {
		/**
		 * δ��¼״̬�µ���ת
		 */
		logout();
		t("�ҵ�");
		// δ��¼״̬�²�չʾ�ҵ�����
		if (solo.searchText("�ҵ�����", 1, false, true)) {
			showErrLog(tag + ":newFarmer_jump():δ��¼״̬�²�չʾ�ҵ�����");
		}
		// δ��¼״̬��ҳ�����ת
		v("com.ksfc.newfarmer:id/head_View");
		solo.assertCurrentActivity(tag + "newFarmer_jump():��¼ҳ��",
				"LoginActivity");
		g();
		t("�ҵĶ���");
		solo.assertCurrentActivity(tag + "newFarmer_jump():�ҵĶ���",
				"LoginActivity");
		g();
		t("�����̳�");
		if (!solo.searchText("�һ���¼", 1, false, true)) {
			showErrLog(tag + ":newFarmer_jump():�����̳�");
		}
		g();
		t("��ũ����");
		solo.assertCurrentActivity(tag + "newFarmer_jump():��ũ����",
				"LoginActivity");
		g();
		t("�ͷ��绰");
		if (!solo.searchText("����", 1, false, true)) {
			showErrLog(tag + ":newFarmer_jump():�ͷ��绰");
		}
		t("ȡ��");
		t("����");
		solo.assertCurrentActivity(tag + "newFarmer_jump():����",
				"SettingActivity");
		g();
		t("��ҳ");
		solo.assertCurrentActivity(tag + "newFarmer_jump():��ҳ",
				"HomepageActivity");
		t("�ҵ�");
		t("���ﳵ");
		solo.assertCurrentActivity(tag + "newFarmer_jump():���ﳵ",
				"ShoppingCartActivity");
		t("�ҵ�");
		t("��Ѷ");
		solo.assertCurrentActivity(tag + "newFarmer_jump():��Ѷ",
				"NewFarmerInfomationActivity");
		t("��ҳ");
		
		/**
		 * ��¼״̬�µ���ת
		 */
		login_sure(Config.pNum_reg);
		t("�ҵ�");
		v("com.ksfc.newfarmer:id/head_View");
		if (!solo.searchText("�ҵ�ͷ��", 1, false, true)) {
			showErrLog(tag + ":newFarmer_jump():������Ϣ");
		}
		g();
		t("�ҵĶ���");
		if (!solo.searchText("�ҵĶ���", 1, false, true)) {
			showErrLog(tag + ":newFarmer_jump():�ҵĶ���");
		}
		g();
		t("�����̳�");
		if (!solo.searchText("�һ���¼", 1, false, true)) {
			showErrLog(tag + ":newFarmer_jump():��½��Ļ����̳�");
		}
		g();
		t("��ũ����");
		if (!solo.searchText("�ҵĴ���", 1, false, true)) {
			showErrLog(tag + ":newFarmer_jump():��½�����ũ����");
		}
		g();
		t("�ͷ��绰");
		if (!solo.searchText("����", 1, false, true)) {
			showErrLog(tag + ":newFarmer_jump():�ͷ��绰");
		}
		t("ȡ��");
		t("����");
		solo.assertCurrentActivity(tag + "newFarmer_jump():��½�������",
				"SettingActivity");
		g();
		t("��ҳ");
		solo.assertCurrentActivity(tag + "newFarmer_jump():��½�����ҳ",
				"HomepageActivity");
		t("�ҵ�");
		t("���ﳵ");
		solo.assertCurrentActivity(tag + "newFarmer_jump():��½��Ĺ��ﳵ",
				"ShoppingCartActivity");
		t("�ҵ�");
		t("��Ѷ");
		solo.assertCurrentActivity(tag + "newFarmer_jump():��½�����Ѷ",
				"NewFarmerInfomationActivity");
		t("�ҵ�");
	}

	/**
	 * ����ҳ��
	 */
	public void setting() {
		t("����");
		// �ر���Ϣ֪ͨ
		if (solo.isCheckBoxChecked(0)) {
			solo.clickOnCheckBox(0);
			if (!solo.searchText("ȷ��", 1, false, true)) {
				showErrLog(tag + ":setting():�ر���Ϣ֪ͨ");
			}
			solo.clickOnButton("ȷ��");
			s();
		}
		solo.clickOnCheckBox(0);
		s();
		// �������
		t("�������");
		if (!solo.searchText("ȷ��", 1, false, true)) {
			showErrLog(tag + ":setting():�������");
		}
		solo.clickOnButton("ȷ��");
		solo.sleep(1000);
		if (!solo.waitForText("�����Ѿ�����ɾ��ˣ�")) {
			showErrLog(tag + ":setting():ȷ���������");
		}
		// �汾���²������°汾
		t("�汾����");
		if (solo.searchText("�ݲ�����", 1, false, true)) {
			t("�ݲ�����");
			t("�汾����");
			t("��������");
		} else {
			t("�汾����");
			if (!solo.waitForText("���°汾")) {
				showErrLog(tag + ":setting():�汾�����°汾");
			}
		}
		// �Ƽ�����ũ�˸�����
		t("�Ƽ�����ũ�˸�����");
		if (!solo.searchText("����", 1, false, true)) {
			showErrLog(tag + ":setting():�Ƽ�����ũ�˸�����");
		}
		g();
		// ����
		t("����");
		if (!solo.searchText("��������", 1, false, true)) {
			showErrLog(tag + ":setting():����");
		}
		g();
	}
}
