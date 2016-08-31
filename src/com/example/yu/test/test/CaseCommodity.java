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

	// ��Ʒ����ҳ��
	public void test_commodityParticulars() {
		// ��ר��������Ʒ����ҳ��
		logout();
		t("����ר��");
		solo.clickInList(1);
		s();

		// ���ҹ�����ƷͼƬ��Ϣ
		View view = solo.getView("com.ksfc.newfarmer:id/imageView");
		dragView(view, 0.8f, 0.5f, 0.3f, 0.5f);
		dragView(view, 0.8f, 0.5f, 0.3f, 0.5f);
		dragView(view, 0.8f, 0.5f, 0.3f, 0.5f);

		// ����Ŵ�ͼƬ
		solo.clickOnScreen(360, 500);
		g();

		// ���»������Ʒ����
		solo.drag(460, 460, 900, 400, 3);
		solo.drag(460, 460, 900, 400, 3);

		// �л���Ʒ��������
		solo.drag(460, 460, 900, 400, 3);
		t("��ϸ����");
		t("����˵��");

		// ��Ʒ�������޸�
		// ͨ����+-�����޸���Ʒ����
		t("���빺�ﳵ");
		for (int a = 0; a < 4; a++) {
			v("pop_discount_jia");
		}
		for (int b = 0; b < 4; b++) {
			v("pop_discount_jian");
		}

		// ��Ʒ����Ϊ9999ʱ��������
		clear("pop_discount_geshu");
		enter("pop_discount_geshu", "9999");
		v("pop_discount_jia");
		if (!solo.waitForText("��Ʒ�������ܴ���9999")) {
			showErrLog(tag + ":commodityParticulars():��Ʒ����Ϊ9999ʱ��������");
		}

		// ��Ʒ����Ϊ1ʱ�����������
		clear("pop_discount_geshu");
		enter("pop_discount_geshu", "1");
		v("pop_discount_jian");
		if (!solo.waitForText("��Ʒ���������ټ�����")) {
			showErrLog(tag + ":commodityParticulars(): ��Ʒ����Ϊ1ʱ�����������");
		}

		// ����Ʒ������Ϊ0
		clear("pop_discount_geshu");
		enter("pop_discount_geshu", "0");
		EditText et2 = (EditText) solo.getView("pop_discount_geshu");
		String s2 = (String) et2.getText().toString();
		int a2 = Integer.parseInt(s2);
		if (a2 != 1) {
			showErrLog(tag + ":commodityParticulars():�����ּ��̽���Ʒ������Ϊ0");
		}

		// �����������ȷ����Ʒ����
		int x = 1 + (int) (Math.random() * 9999);
		String number = x + "";
		clear("pop_discount_geshu");
		enter("pop_discount_geshu", number);
		EditText et3 = (EditText) solo.getView("pop_discount_geshu");
		String s3 = (String) et3.getText().toString();
		int a3 = Integer.parseInt(s3);
		if (a3 != x) {
			showErrLog(tag + ":commodityParticulars():�����ּ���������ȷ����Ʒ����");
		}

		// δ��¼�������Ʒ����δѡ����ȫ�ͼ��빺�ﳵ
		t("ȷ��");
		if (!solo.waitForText("��ѡ����Ʒ��Ϣ")) {
			showErrLog(tag + "commodityParticulars():δ��¼�������Ʒ����δѡ����ȫ�ͼ��빺�ﳵ");
		}

		// δ��¼�����ѡ������Ʒ���Ժ���빺�ﳵ
		t("2.0T �Զ���6DCT��");
		t("������");
		t("���ƺ�");
		t("ȷ��");
		if (!solo.waitForText("��ӹ��ﳵ�ɹ�")) {
			showErrLog(tag + "commodityParticulars():δ��¼�����ѡ������Ʒ���Ժ���빺�ﳵ");
		}

		// ��½����Ʒ����δѡ����ͼ��빺�ﳵ
		g();
		g();
		login_sure(Config.pNum_reg);
		t("����ר��");
		solo.clickInList(1);
		t("���빺�ﳵ");
		t("ȷ��");
		if (!solo.waitForText("��ѡ����Ʒ��Ϣ")) {
			showErrLog(tag + "commodityParticulars():��½����Ʒ����δѡ����ͼ��빺�ﳵ");
		}

		// ��½����Ʒ����ѡ���겢���빺�ﳵ
		t("2.0T �Զ���6DCT��");
		t("������");
		t("���ƺ�");
		t("ȷ��");
		if (!solo.waitForText("��ӹ��ﳵ�ɹ�")) {
			showErrLog(tag + "commodityParticulars():δ��¼�����ѡ������Ʒ���Ժ���빺�ﳵ");
		}
		g();
		g();

		// δ��¼��������
		logout();
		t("����ר��");
		solo.clickInList(1);
		s();
		t("��������");
		t("ȷ��");
		solo.assertCurrentActivity(
				tag + ":test_commodityParticulars():δ��¼��������", "LoginActivity");

		// ��¼����Ʒ����δѡ����ȫ����������
		clear("com.ksfc.newfarmer:id/login_layout_phone");
		enter(("com.ksfc.newfarmer:id/login_layout_phone"), Config.pNum_reg);//
		enter(("com.ksfc.newfarmer:id/login_layoutpassword"), Config.pwd_cur);
		t("ȷ�ϵ�¼");
		if (!solo.searchText("ȷ��", 1, false, true)) {
			showErrLog(tag + "commodityParticulars():��¼����Ʒ����δѡ����ȫ����������");
		}
		t("ȷ��");
		if (!solo.waitForText("��ѡ����Ʒ��Ϣ")) {
			showErrLog(tag + "commodityParticulars():��¼����Ʒ����δѡ����ȫ����������");
		}

		// ��½��ѡ������Ʒ���Ժ�ȷ����������
		t("2.0T �Զ���6DCT��");
		t("������");
		t("���ƺ�");
		t("ȷ��");
		if (!(solo.searchText("�ύ����", 0, false, true))) {
			showErrLog(tag + "commodityParticulars():��½��ѡ������Ʒ���Ժ�ȷ����������");
		}
		solo.goBackToActivity("HomepageActivity");
	}
}