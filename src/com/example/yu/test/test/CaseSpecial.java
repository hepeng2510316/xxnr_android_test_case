package com.example.yu.test.test;

import com.example.yu.test.test.RunTestCase.*;
import com.robotium.solo.Solo;

public class CaseSpecial extends BaseCase {

	public String tag = " CaseSpecial";

	public static CaseSpecial caseInstance(Solo solo1) {
		CaseSpecial instance = new CaseSpecial();
		instance.instance(solo1);
		return instance;
	}

	public void test_run() {
		fertilizer();
		car();
	}

	// ����ר��
	public void fertilizer() {
		t("����ר��");
		// ����ˢ����Ʒ
		solo.drag(500, 500, 1000, 650, 3);
		solo.drag(500, 500, 1000, 650, 3);

		// ����ˢ����Ʒ
		solo.drag(500, 500, 650, 1000, 3);
		solo.drag(500, 500, 600, 1000, 3);

		// ���ض�����ť
		solo.drag(400, 400, 1000, 650, 3);
		v("com.ksfc.newfarmer:id/return_top");

		// ������Ʒ����ҳ�沢����
		int x = (int) (Math.random() * 5);
		solo.clickInList(x);
		solo.assertCurrentActivity(tag + ":fertilizer():������Ʒ����ҳ�沢����",
				"GoodsDetailActivity");
		g();
		// �۸�����
		t("�۸�");
		t("�۸�");

		// ɸѡƷ��
		t("ɸѡ");
		t("�л�����");
		t("ȷ��");

		// ɸѡƷ��
		t("ɸѡ");
		t("����");
		t("�л���");
		t("ȷ��");

		// �۸�ɸѡ
		t("ɸѡ");
		t("����");
		t("2000-3000Ԫ");
		t("ȷ��");

		// �༶ɸѡ
		t("ɸѡ");
		t("����");
		t("������");
		t("�л�����");
		t("�л���");
		t("���Ϸ�");
		t("2000-3000Ԫ");
		t("ȷ��");

		// ѡ�����õ���û��ȷ��
		t("ɸѡ");
		t("����");
		g();
		solo.drag(500, 500, 1000, 650, 3);
		s();

		// ���ú�ȷ��
		v("com.ksfc.newfarmer:id/goods_shaixuan_rel");
		t("����");
		t("ȷ��");

		// �ۺϷ���Ĭ��״̬
		t("�۸�");
		t("�ۺ�");
		g();
	}

	// ����ר��
	public void car() {
		// �����»�ˢ����Ʒ
		t("����ר��");
		// ����ˢ����Ʒ
		solo.drag(500, 500, 1000, 650, 3);
		s();
		solo.drag(500, 500, 1000, 650, 3);
		s();

		// ����ˢ����Ʒ
		solo.drag(500, 500, 650, 1000, 3);
		s();
		solo.drag(500, 500, 600, 1000, 3);
		s();

		// ���ض�����ť
		solo.drag(400, 400, 1000, 650, 3);
		v("com.ksfc.newfarmer:id/return_top");

		// ������Ʒ����ҳ�沢����
		int x = (int) (Math.random() * 5);
		solo.clickInList(x);
		solo.assertCurrentActivity(tag + ":car():������Ʒ����ҳ�沢����",
				"GoodsDetailActivity");
		g();

		// �۸�����
		t("�۸�");
		t("�۸�");

		// ɸѡƷ��
		t("ɸѡ");
		t("����");
		t("ȷ��");

		// ɸѡ����
		t("ɸѡ");
		t("����");
		t("MPV");
		t("ȷ��");

		// �۸�ɸѡ
		t("ɸѡ");
		t("����");
		t("5��-6��");
		t("ȷ��");

		// ɸѡ��ϵ
		t("ɸѡ");
		t("����");
		t("���S3");
		t("ȷ��");

		// �༶ɸѡ
		t("ɸѡ");
		t("����");
		t("����");
		t("����");
		t("SUV");
		t("�γ�");
		t("���S2");
		t("���S5");
		t("6��-7��");
		t("ȷ��");

		// ѡ�����õ���û��ȷ��
		t("ɸѡ");
		t("����");
		g();
		solo.drag(500, 500, 1000, 650, 3);
		s();

		// ���ú�ȷ��
		v("com.ksfc.newfarmer:id/goods_shaixuan_rel");
		t("����");
		t("ȷ��");

		// �ۺϷ���Ĭ��״̬
		t("�۸�");
		t("�ۺ�");
		g();
	}
}