/* ������վ��http://www.androidbks.com
* �ǽ�iOS���ã�http://www.51work6.com
* �ǽ�iOS�������߿��ã�http://v.51work6.com
* �ǽ�iOS��������΢����http://weibo.com/u/3215753973
* ����΢����http://weibo.com/516inc
* �ٷ�csdn���ͣ�http://blog.csdn.net/tonny_guan
* QQ��1575716557 ���䣺jylong06@163.com
*/ 

package com.god.holywar;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

/**
 * Ӧ�ù����࣬��װ��һЩ������ͨ�÷�����
 * 
 * @author �ض���
 * 
 */
public class AppUtil {

	public static final String URL_PREFIX = "http://androidbks.com/holywar/";
	public static String verifycode = "";// ��֤��
	public static String faction = "";// ����
	public static String heroname = "";// Ӣ������
	public static String herolevel = "";// Ӣ�ۼ���
	
	public static String email = "���androidbks.comע���û�����";//���androidbks.comע���û�����

	public static final String FACTION_FAIRYLAND = "0"; // ���ɱ�־ 0 �ɽ�
	public static final String FACTION_GHOSTLAND = "1"; // ���ɱ�־ 1ڤ��

	/**
	 * ֻ��һ��close��ť����Ϣ��ʾ��
	 * 
	 * @param context
	 * @param message
	 */
	public static void button1Dialog(Context context, String message) {
		AlertDialog dlg = new AlertDialog.Builder(context)
				.setTitle(message)
				.setIcon(R.drawable.info)
				.setNegativeButton(R.string.close,
						new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog,
									int which) {
							}
						}).create();
		dlg.show();
	}

	/**
	 * ����������� �����res�н�����ͼƬ��id
	 * 
	 * @param name
	 *            ����������� ����
	 * @return ������ͼƬ��id ����
	 */
	public static int[] getBuidingImgId(String name[]) {
		int[] building1 = new int[20];
		for (int i = 0; i < 20; i++) {
			String aname = name[i];
			if (aname.equals("space")) {
				building1[i] = R.drawable.blank03;
				continue;
			}
			if (aname.equals("temple")) {
				building1[i] = R.drawable.temple;
				continue;
			}
			if (aname.equals("residence")) {
				building1[i] = R.drawable.residence;
				continue;
			}
			if (aname.equals("storehouse")) {
				building1[i] = R.drawable.storehouse;
				continue;
			}
			if (aname.equals("chamber_secrets")) {
				building1[i] = R.drawable.chamber_secrets;
				continue;
			}
			if (aname.equals("huzhongsi")) {
				building1[i] = R.drawable.meeting_room;
				continue;
			}
			if (aname.equals("grand_council")) {
				building1[i] = R.drawable.grand_council;
				continue;
			}
			if (aname.equals("parade_ground")) {
				building1[i] = R.drawable.parade_ground;
				continue;
			}
			if (aname.equals("demons_pavilion")) {
				building1[i] = R.drawable.demons_pavilion;
				continue;
			}
			if (aname.equals("gongjingying")) {
				building1[i] = R.drawable.archery_camp;
				continue;
			}
			if (aname.equals("voodoo")) {
				building1[i] = R.drawable.voodoo;
				continue;
			}
			if (aname.equals("martial_club")) {
				building1[i] = R.drawable.martial_club;
				continue;
			}
			if (aname.equals("cavalry_camp")) {
				building1[i] = R.drawable.cavalry_camp;
				continue;
			}
			if (aname.equals("army_arsenal")) {
				building1[i] = R.drawable.army_arsenal;
				continue;
			}
			if (aname.equals("sawmill")) {
				building1[i] = R.drawable.blank03;
				continue;
			}
			if (aname.equals("grain_field")) {
				building1[i] = R.drawable.blank03;
				continue;
			}
			if (aname.equals("land_tower_air_defense")) {
				building1[i] = R.drawable.land_tower_air_defense;
				continue;
			}
			if (aname.equals("wall")) {
				building1[i] = R.drawable.blank02;
				continue;
			}
			if (aname.equals("land_tower_ground_defense")) {
				building1[i] = R.drawable.land_tower_ground_defense;
				continue;
			}
			if (aname.equals("space_land_tower")) {
				building1[i] = R.drawable.blank01;
			}
		}
		return building1;
	}

	/**
	 * ͨ��ѡ��ؿ�ͼƬid�͵ؿ����ƣ���õ����Ի�������Ҫͼ�ꡣ
	 * �����ǽ��ľ�ĳ����ռ���������������Ƶ�ͼƬ�ڶԻ���ͼ�겻ͬ��
	 * @param imageid
	 * @param name
	 * @return
	 */
	public static int getDialogIconId(int imageid, String name) {
		int iconid = imageid;
		if (iconid == R.drawable.blank01 || iconid == R.drawable.blank02
				|| iconid == R.drawable.blank03) {
			if (name.equals("grain_field")) { //����
				return R.drawable.grain_field;
			} else if (name.equals("wall")) {//��ǽ
				return R.drawable.wall;
			} else if (name.equals("sawmill")) {//ľ�ĳ�
				return R.drawable.sawmill;
			}  else if (name.equals("space_land_tower")) {//�ռ���
				return R.drawable.land_tower;
			} 
			
		}
		return imageid;
	}

	/**
	 * ����������� �����res�н�����ͼƬ��id
	 * 
	 * @param name
	 *            ����ƴ������
	 * @return �����߼���
	 */
	public static String getHanZname(String aname) {
		if (aname.equals("space")) {
			return "�յ�";
		}
		if (aname.equals("temple")) {
			return "������";
		}
		if (aname.equals("residence")) {
			return "���";
		}
		if (aname.equals("storehouse")) {
			return "�ֿ�";
		}
		if (aname.equals("chamber_secrets")) {
			return "�ܿ�";
		}
		if (aname.equals("meeting_room")) {
			return "����˾";
		}
		if (aname.equals("grand_council")) {
			return "������";
		}
		if (aname.equals("parade_ground")) {
			return "������";
		}
		if (aname.equals("demons_pavilion")) {
			return "��ħ¥";
		}
		if (aname.equals("archery_camp")) {
			return "��Ӫ";
		}
		if (aname.equals("voodoo")) {
			return "�׶���";
		}
		if (aname.equals("martial_club")) {
			return "��ʿ��";
		}
		if (aname.equals("cavalry_camp")) {
			return "����Ӫ";
		}
		if (aname.equals("army_arsenal")) {
			return "���ɷ�";
		}
		if (aname.equals("sawmill")) {
			return "ľ�ĳ�";
		}
		if (aname.equals("grain_field")) {
			return "����";
		}
		if (aname.equals("land_tower_air_defense")) {
			return "���ռ���";
		}
		if (aname.equals("wall")) {
			return "��ǽ";
		}
		if (aname.equals("land_tower_ground_defense")) {
			return "���ؼ���";
		}
		if (aname.equals("space_land_tower")) {
			return "�ռ���";
		}
		return "�յ�";
	}
	
	/**
	 * �����ﺺ���� ��ý����߼�����
	 * 
	 * @param hanname
	 *            �����߼���
	 * @return �����ﺺ�ֵ�����
	 */
	public static String getNameHanZ(String hanname) {
		if (hanname.equals("�յ�")) {
			return "space";
		}
		if (hanname.equals("������")) {
			return "temple";
		}
		if (hanname.equals("���")) {
			return "residence";
		}
		if (hanname.equals("�ֿ�")) {
			return "storehouse";
		}
		if (hanname.equals("�ܿ�")) {
			return "chamber_secrets";
		}
		if (hanname.equals("����˾")) {
			return "meeting_room";
		}
		if (hanname.equals("������")) {
			return "grand_council";
		}
		if (hanname.equals("������")) {
			return "parade_ground";
		}
		if (hanname.equals("��ħ¥")) {
			return "demons_pavilion";
		}
		if (hanname.equals("��Ӫ")) {
			return "archery_camp";
		}
		if (hanname.equals("�׶���")) {
			return "voodoo";
		}
		if (hanname.equals("��ʿ��")) {
			return "martial_club";
		}
		if (hanname.equals("����Ӫ")) {
			return  "cavalry_camp";
		}
		if (hanname.equals("���ɷ�")) {
			return "army_arsenal";
		}
		if (hanname.equals("ľ�ĳ�")) {
			return "sawmill";
		}
		if (hanname.equals("����")) {
			return "grain_field";
		}
		if (hanname.equals("���ռ���")) {
			return "land_tower_air_defense";
		}
		if (hanname.equals("��ǽ")) {
			return "wall";
		}
		if (hanname.equals("���ؼ���")) {
			return "land_tower_ground_defense";
		}
		if (hanname.equals("�ռ���")) {
			return "space_land_tower";
		}
		return "space";
	}
	/**
	 * ͨ���������ֺͱ������֣�������ļһ���б�����Ҫ������Ϣ�� ��Щ��Ϣ�Ƿ���һ������ģ���������ļ��������ľ�ġ���ʳ��������
	 * 
	 * @param buildingName
	 *            ��������
	 * @param soldiername
	 *            ��������
	 * @return
	 */
	public static String[] recruitSoldierStuffInfo(String buildingName,
			String soldiername) {
		String[] arySoldierStuffInfo = new String[5];
		String soldierHZname = "";
		String wood = "";
		String food = "";
		String ironOre = "";
		if (buildingName.equals("parade_ground")) {
			if (soldiername.equals("transport_soldier")) {
				soldierHZname = "�����";
				wood = "700";
				food = "600";
				ironOre = "0";
			}
			if (soldiername.equals("scout_soldier")) {
				soldierHZname = "����";
				wood = "350";
				food = "300";
				ironOre = "0";
			}
			if (soldiername.equals("militia")) {
				soldierHZname = "���";
				wood = "500";
				food = "400";
				ironOre = "0";
			}
			if (soldiername.equals("spearman")) {
				soldierHZname = "ǹ��";
				wood = "700";
				food = "625";
				ironOre = "0";
			}
			if (soldiername.equals("assassin")) {
				soldierHZname = "�̿�";
				wood = "875";
				food = "775";
				ironOre = "125";
			}
		}
		if (buildingName.equals("marksman")) {
			soldierHZname = "������";
			wood = "700";
			food = "600";
			ironOre = "0";

		}
		if (buildingName.equals("voodoo_man")) {
			soldierHZname = "�׶���ʿ";
			wood = "1100";
			food = "1000";
			ironOre = "300";

		}
		if (buildingName.equals("warrior")) {
			soldierHZname = "��ʿ";
			wood = "1600";
			food = "1400";
			ironOre = "300";

		}
		if (buildingName.equals("military_general")) {
			soldierHZname = "����";
			wood = "1875";
			food = "1625";
			ironOre = "500";

		}
		if (buildingName.equals("army_arsenal")) {
			if (soldiername.equals("battering_ram")) {
				soldierHZname = "��ײ��";
				wood = "10000";
				food = "10000";
				ironOre = "6600";
			}
			if (soldiername.equals("catapult")) {
				soldierHZname = "Ͷʯ��";
				wood = "17000";
				food = "17000";
				ironOre = "12600";
			}
		}

		arySoldierStuffInfo[0] = soldiername;
		arySoldierStuffInfo[1] = soldierHZname;
		arySoldierStuffInfo[2] = wood;
		arySoldierStuffInfo[3] = food;
		arySoldierStuffInfo[4] = ironOre;

		return arySoldierStuffInfo;
	}

}
