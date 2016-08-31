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
	 * û�д����ͻ����˻�
	 */
	public void delegate_null() {

		login_sure(Config.pNum_null);
		t("�ҵ�");
		t("��ũ����");
		// û�пͻ����˻��ҵĿͻ�ҳ��չʾ
		if (!solo.searchText("��û�������û�Ŷ~", 1, false, true)) {
			showErrLog(tag + ":delegate_null():û�пͻ����˻��ҵĿͻ�ҳ��չʾ");
		}
		// û�д�����˻��ҵĴ���ҳ��չʾ
		v("com.ksfc.newfarmer:id/radio_button2");
		if (!solo.searchText("*��������Ӻ󲻿��޸�,����ϸ�˶�", 1, false, true)) {
			showErrLog(tag + ":delegate_null():û�д�����˻��ҵĴ���ҳ��չʾ");
		}
		/**
		 * �����ũ����Ϊ�˷����Ժ���ԣ���������ȷ�������Ĳ�����
		 */
		// δ��д�ֻ��ž����
		v("com.ksfc.newfarmer:id/add_inviter");
		if (!solo.waitForText("������һ���ֻ�����")) {
			showErrLog(tag + ":delegate_null():δ��д�ֻ��ž����");
		}
		// ��д������ֻ�����
		enter("com.ksfc.newfarmer:id/my_inviter_fragment_edittext",
				Config.pNum_err);
		v("com.ksfc.newfarmer:id/add_inviter");
		if (!solo.waitForText("��������ֻ����벻��ȷ")) {
			showErrLog(tag + ":delegate_null():��д������ֻ�����");
		}
		g();
	}

	/**
	 * �пͻ�����������֤Ϊ��ũ�����˵��˻�
	 */
	public void delegate() {
		login_sure(Config.pNum_reg);
		t("�ҵ�");
		t("��ũ����");
		// �ҵĿͻ�ҳ��ȥ�鿴�ͻ�����
		v("com.ksfc.newfarmer:id/my_inviter_nickname");
		if (!solo.searchText("�ͻ�����")) {
			showErrLog(tag + ":delegate():�ҵĿͻ�ҳ��ȥ�鿴�ͻ�����");
		}
		/**
		 * �ҵĿͻ�����״̬����ʱ�к����ʾ
		 */
		// ʹ�ÿͻ��˺��µ���������ũ������˻��鿴
		g();
		g();
		t("��ҳ");
		login_sure("13718603051");
		t("����ר��");
		solo.clickInList(2);
		t("��������");
		t("ȷ��");
		v("com.ksfc.newfarmer:id/deliveries_way_home");
		v("com.ksfc.newfarmer:id/ordering_go_bt");
		g();
		login_sure(Config.pNum_reg);
		t("�ҵ�");
		t("��ũ����");
		// �ͻ�����״̬�и���
		View view = solo
				.getView("com.ksfc.newfarmer:id/my_inviter_nickname_remind_dot");
		if (view.getVisibility() != View.VISIBLE) {
			showErrLog(tag + ":delegate():�ͻ�����״̬�и���");
		}
		// �鿴���ͻ�������С�����ʧ
		v("com.ksfc.newfarmer:id/my_inviter_nickname");
		g();
		view = solo
				.getView("com.ksfc.newfarmer:id/my_inviter_nickname_remind_dot");
		if (view.getVisibility() != View.INVISIBLE) {
			showErrLog(tag + ":delegate():�鿴���ͻ�������С�����ʧ");
		}

		/**
		 * �ҵĴ���
		 */
		// ���ҵĴ���ҳ��������绰��ť
		t("�ҵĴ���");
		if (!(solo.searchText("���", 1, false, true))) {
			v("com.ksfc.newfarmer:id/my_inviter_phone_icon");
			t("ȡ��");
		}// �����ҵĴ���ҳ�沢���Բ���绰
		v("com.ksfc.newfarmer:id/radio_button2");
		v("com.ksfc.newfarmer:id/my_inviter_phone_icon");
		if (!solo.searchText("����")) {
			showErrLog(tag + ":delegate():�����ҵĴ���ҳ�沢���Բ���绰");
		}
		solo.clickOnButton("ȡ��");

		/**
		 * �ͻ��Ǽ�
		 */
		// �ͻ��Ǽ�ҳ��鿴�ͻ�����
		v("com.ksfc.newfarmer:id/item_already_customer_name");
		if (!solo.searchText("�ͻ�����")) {
			showErrLog(tag + ":delegate():�ͻ��Ǽ�ҳ��鿴�ͻ�����");
		}
		g();
		g();
	}

	/**
	 * ���Ǳ�ڿͻ�
	 */
	public void add() {
		login_sure(Config.pNum_reg);
		t("�ҵ�");
		t("��ũ����");
		t("�ͻ��Ǽ�");
		// δѡ�����ʱ����ѡ��ֵ�
		v("com.ksfc.newfarmer:id/choice_town_text");
		if (!solo.waitForText("����ѡ�����")) {
			showErrLog(tag + ":add():δѡ�����ʱ����ѡ��ֵ�");
		}
		// δ��д��������
		v("com.ksfc.newfarmer:id/add_potential_customer");
		t("����");
		if (!solo.waitForText("��������Ϣ")) {
			showErrLog(tag + ":add():δ��д��������");
		}
		// �������Ȳ��ܳ���12���ַ�
		enter("com.ksfc.newfarmer:id/name_tv", getRandomString(16));
		if (getTextViewString("com.ksfc.newfarmer:id/name_tv").length() != 12) {
			showErrLog(tag + ":add():�������Ȳ��ܳ���12���ַ�");
		}
		// δ��д�ֻ��ű���
		t("����");
		if (!solo.waitForText("��������Ϣ")) {
			showErrLog(tag + ":add():δ��д�ֻ��ű���");
		}
		// ��д������ֻ���
		enter("com.ksfc.newfarmer:id/phone_tv", Config.pNum_err);
		if (!solo.waitForText("��������Ϣ")) {
			showErrLog(tag + ":add():��д������ֻ���");
		}
		// ��д��ע������ֻ���
		clear("com.ksfc.newfarmer:id/phone_tv");
		enter("com.ksfc.newfarmer:id/phone_tv", Config.pNum_reg);
		if (!solo.searchText("�ÿͻ���ע�ᣬ������ֱ�������Ϊ��ũ�������������ٶ������ṩ����")) {
			showErrLog(tag + ":delegate():��д��ע������ֻ���");
		}
		// ��д�ѵǼǹ����ֻ���
		clear("com.ksfc.newfarmer:id/phone_tv");
		enter("com.ksfc.newfarmer:id/phone_tv", "13333333333");
		if (!solo.searchText("com.ksfc.newfarmer:id/phone_error")) {
			showErrLog(tag + ":delegate():��д�ѵǼǹ����ֻ���");
		}
		clear("com.ksfc.newfarmer:id/phone_tv");
		enter("com.ksfc.newfarmer:id/phone_tv", "133" + getRandomIntString(8));
		// ѡ���Ա�Ϊ��
		if (!solo.isCheckBoxChecked(1)) {
			v("com.ksfc.newfarmer:id/btn_check_item_item");
			if (solo.isCheckBoxChecked(4)) {
				showErrLog(tag + ":delegate():ѡ���Ա�Ϊ��");
			}
		} else {
			v("com.ksfc.newfarmer:id/btn_check_item_item1");
			if (solo.isCheckBoxChecked(1)) {
				showErrLog(tag + ":delegate():ѡ���Ա�ΪŮ");
			}
		}
		// δ��д����
		t("����");
		if (!solo.waitForText("��������Ϣ")) {
			showErrLog(tag + ":add():δ��д����");
		}
		// δ��д�ֵ�
		v("com.ksfc.newfarmer:id/choice_city_layout");
		solo.clickInList(1);
		solo.clickInList(getRandomInt(1, 12));
		solo.clickInList(getRandomInt(1, 6));
		t("����");
		if (!solo.waitForText("��������Ϣ")) {
			showErrLog(tag + ":add():δ��д�ֵ�");
		}
		// δ��д�����Ʒ����
		v("com.ksfc.newfarmer:id/choice_town_layout");
		solo.clickInList(getRandomInt(1, 4));
		t("����");
		if (!solo.waitForText("��������Ϣ")) {
			showErrLog(tag + ":add():δ��д�����Ʒ����");
		}
		// ����ѡ��������ֵ��Ƿ�����
		v("com.ksfc.newfarmer:id/choice_city_layout");
		solo.clickInList(1);
		solo.clickInList(getRandomInt(1, 12));
		solo.clickInList(getRandomInt(1, 6));
		if (!getTextHintString("com.ksfc.newfarmer:id/choice_town_text")
				.equalsIgnoreCase("ѡ�����ڽֵ�������")) {
			showErrLog(tag + ":add(): ����ѡ��������ֵ��Ƿ�����");
		}
		//��ѡ�������Ʒ��ȷ��
		v("com.ksfc.newfarmer:id/choice_town_layout");
		solo.clickInList(getRandomInt(1, 4));
		v("com.ksfc.newfarmer:id/choose_type_ll");
		t("ȷ��");
		if (!solo.waitForText("������ѡ��һ�������Ʒ")) {
			showErrLog(tag + ":add():��ѡ�������Ʒ��ȷ��");
		}
		

	}
}