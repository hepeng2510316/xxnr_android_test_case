package com.example.yu.test.test;

import com.example.yu.test.test.RunTestCase.*;
import com.robotium.solo.Solo;

import android.view.View;
public class CasePayWay extends BaseCase {
	public static String tag = "CasePayWay";

	public static CasePayWay caseInstance(Solo solo1) {
		CasePayWay instance = new CasePayWay();
		instance.instance(solo1);
		return instance;
	}

	public void test_run() {
		payWay();
		separate();
	}

	/**
	 * ȫ��֧����֧����ʽ
	 */
	public void payWay() {
		login_sure(Config.pNum_reg);
		/**
		 * ����3000���޷�ѡ��ִ�֧��
		 */
		t("����ר��");
		solo.clickInList(2);
		t("��������");
		t("ȷ��");
		t("���͵���");
		v("com.ksfc.newfarmer:id/ordering_go_bt");
		// �жϴ��������ȫ��֧������Ƿ�һ��
		String all_one = getTextViewString("com.ksfc.newfarmer:id/payway_sumPrice");
		String all = all_one.substring(0, all_one.length() - 2);
		String wait_one = getTextViewString("com.ksfc.newfarmer:id/payWay_pay_total_price");
		String wait = wait_one.substring(1, wait_one.length() - 1);
		if (!all.equals(wait)) {
			showErrLog(tag + ":payWay():�жϴ��������ȫ��֧������Ƿ�һ��");
		}
		// �����ܷ�ִ�֧��
		t("�ִ�֧��");
		View view_one = solo
				.getView("com.ksfc.newfarmer:id/payWay_discount_jia");
		View view_two = solo
				.getView("com.ksfc.newfarmer:id/payWay_discount_jian");
		if (view_one.isEnabled() | view_two.isEnabled()) {
			showErrLog(tag + ":payWay():�����ܷ�ִ�֧��");
		}
		// ֧����֧��
		t("ȫ��֧��");
		v("com.ksfc.newfarmer:id/alipay_ll");
		t("ȥ֧��");
		solo.sleep(1000);
		/**
		 * EPSO֧��
		 */
		// EPOSˢ��ȫ��֧��
		v("com.ksfc.newfarmer:id/pos_ll");
		t("ȥ֧��");
		if (!solo.searchText("ȫ��EPOS", 1, false, true)) {
			showErrLog(tag + ":payWay():EPOSˢ��ȫ��֧��");
		}
		// EPSO֧��ҳ��鿴��������
		v("com.ksfc.newfarmer:id/view_other_state_ll");
		if (!solo.searchText("EPOSˢ������", 1, false, true)) {
			showErrLog(tag + ":payWay():EPSO֧��ҳ��鿴��������");
		}
		g();
		// EPOS���ڷ��������֧��
		t("����֧��");
		g();
		if (!solo.waitForText("֧��ʧ��")) {
			showErrLog(tag + ":payWay():EPOS���ڷ��������֧��");
		}
		g();
		/**
		 * ����֧��
		 */
		// ��������֧��ҳ��
		v("com.ksfc.newfarmer:id/bank_dianhui_ll");
		t("ȥ֧��");
		if (!solo.searchText("����֧��", 1, false, true)) {
			showErrLog(tag + ":payWay():��������֧��ҳ��");
		}
		// ���¸���ҳ��ȥ�鿴����
		t("�鿴����");
		if (!solo.searchText("��������", 1, false, true)) {
			showErrLog(tag + ":payWay():���¸���ҳ��ȥ�鿴����");
		}
		// ��������ҳ��鿴����״̬
		v("com.ksfc.newfarmer:id/my_order_detail_id");
		if (!solo.searchText("����״̬", 1, false, true)) {
			showErrLog(tag + ":payWay():��������ҳ��鿴�������״̬");
		}
		g();
		// ��������ҳ��鿴������Ϣ
		v("com.ksfc.newfarmer:id/go_to_pay");
		if (!solo.searchText("����֧��", 1, false, true)) {
			showErrLog(tag + ":payWay():��������ҳ��鿴������Ϣ");
		}
		g();
		// ��������ҳ��ȥ�޸�֧����ʽ
		v("com.ksfc.newfarmer:id/change_pay_type");
		if (!solo.searchText("֧����ʽ", 1, false, true)) {
			showErrLog(tag + ":payWay():��������ҳ��ȥ�޸�֧����ʽ");
		}
		g();
		g();
		g();
	}

	/**
	 * �ִ�֧��
	 */
	public void separate() {
		login_sure(Config.pNum_reg);
		t("����ר��");
		solo.clickInList(5);
		t("��������");
		t("ȷ��");
		t("���͵���");
		v("com.ksfc.newfarmer:id/ordering_go_bt");
		// �жϴ��������ȫ��֧������Ƿ�һ��
		String all_one = getTextViewString("com.ksfc.newfarmer:id/payway_sumPrice");
		String all = all_one.substring(0, all_one.length() -1);
		String wait_one = getTextViewString("com.ksfc.newfarmer:id/payWay_pay_total_price");
		String wait = wait_one.substring(1, wait_one.length());
		double pay_wait = Double.parseDouble(all);
		if (!all.equals(wait)) {
			showErrLog(tag + ":separate():�жϴ��������ȫ��֧������Ƿ�һ��");
		}
		t("�ִ�֧��");
		//����֧�����ִܷ�
		if(solo.searchText("����֧��",1,false,true)){
			showErrLog(tag + ":separate():����֧�����ִܷ�");
		}
		// ��ȡ�ִ�֧���Ľ���ʼֵ�Ƿ�Ϊ3000
		String s = getTextViewString("com.ksfc.newfarmer:id/payWay_discount_price");
		double pay_reality = Double.parseDouble(s);
		if (pay_reality != 3000.00) {
			showErrLog(tag + ":separate():��ȡ�ִ�֧���Ľ���ʼֵ�Ƿ�Ϊ3000");
		}

		// �ִ�֧����ͣ����֧�����ֱ�����ڴ������
		while (pay_reality != pay_wait) {
			v("com.ksfc.newfarmer:id/payWay_discount_jia");
			s = getTextViewString("com.ksfc.newfarmer:id/payWay_discount_price");
			double pay_reality_jia = Double.parseDouble(s);
			pay_reality = pay_reality_jia;
		}
		if (pay_reality != pay_wait) {
			showErrLog(tag + ":separate():�ִ�֧����ͣ����֧�����ֱ�����ڴ������");
		}

		// �ִ�֧����ͣ����֧�����ֱ������Ĭ�Ͻ��
		while (pay_reality != 3000) {
			v("com.ksfc.newfarmer:id/payWay_discount_jian");
			s = getTextViewString("com.ksfc.newfarmer:id/payWay_discount_price");
			double pay_reality_jian = Double.parseDouble(s);
			pay_reality = pay_reality_jian;
		}
		if (pay_reality != 3000.00) {
			showErrLog(tag + ":separate():�ִ�֧����ͣ����֧�����ֱ������Ĭ�Ͻ��");
		}
		//֧�����ִ�֧��
		v("com.ksfc.newfarmer:id/alipay_ll");
		t("ȥ֧��");
		solo.sleep(1000);
		// EPOS�ִ�֧��
		v("com.ksfc.newfarmer:id/pos_ll");
		t("ȥ֧��");
		if(!solo.searchText("ȫ��EPOS",1,false,true)){
			showErrLog(tag+":separate():EPOS�ִ�֧��");
		}
	}
}