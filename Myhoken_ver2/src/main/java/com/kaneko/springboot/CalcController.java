package com.kaneko.springboot;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Takuya Kaneko
 *
 *保険料計算クラス
 *年齢・年収・自治体によって計算が変わるプログラム
 *世帯数・世帯収入合計は今回考えない。独身前提
 */

@Controller
public class CalcController {

	//URLパラメータの変数
	int pref;
	int city;

	//選択された市町村名を格納
	String city_name;

	@Autowired
	JdbcTemplate jdbcTemplate;


	//メソッドを指定してGETとPOSTを区別して書く。
	//URLのパラメータをnumで受け取り、numを使用するために@PathVariableをつける。
	@RequestMapping(value="/{num1}/{num2}/calc",method=RequestMethod.GET)
	public ModelAndView calc(ModelAndView mav,@PathVariable int num1,@PathVariable int num2){


		//URLから受け取った値をsendメソッドで使うためにグローバル変数に格納
		pref=num1;
		city=num2;
		//test
		System.err.println(pref+city);

		city_name=HokkaidoController.city_list.get(num2-1).get("name").toString();

			mav.setViewName("calc");
			mav.addObject("msg", "年齢を選んでください");
			//都道府県＆市町村名表示。パンくず。
			mav.addObject("pref_ja", HokkaidoController.pref_ja);
			mav.addObject("city_name", city_name);
			mav.addObject("pref_num", pref);


			return mav;
	}

	@RequestMapping(value="/calc",method=RequestMethod.POST)
	//sendメソッドでフォームからの入力を受け取る
	public ModelAndView send(
			//フォーム送信された値を指定するためのアノテーション
			//valueに入力された値をint radio1の変数に渡される
			@RequestParam(value="radio1",required=false)int radio1,
			@RequestParam(value="select1",required=false)int select1,
			ModelAndView mav) {

		System.err.println(pref+city);
		//参考資料　https://slack-files.com/TC74XEUSW-FDM026YQ2-6f00fe4489
		//        http://www.kokuho-keisan.com/calc/calc.php?area=011002

		//URLから受け取った変数をクエリ文に組み込む。テーブルに紐付いている。対象の保険料計算データをリストに格納。
		List<Map<String, Object>>hokenryou=jdbcTemplate.queryForList("select * from hokenryou where pref_id ="+pref+ " AND city_id2 = "+city);

		//テスト用
//		double jj=(Double.parseDouble(hokenryou.get(0).get("ryouritu1").toString()))/100;;
//		System.err.println(jj);

		//国保計算のための各変数
		//型変換必要。 オブジェクト型→String→double
		//所得割
		double ryourituA=(Double.parseDouble(hokenryou.get(0).get("ryouritu1").toString()))/100;
		double ryourituB=(Double.parseDouble(hokenryou.get(0).get("ryouritu2").toString()))/100;
		double ryourituC=(Double.parseDouble(hokenryou.get(0).get("ryouritu3").toString()))/100;

		//均等割
		int kintoA=Integer.parseInt(hokenryou.get(0).get("kinto1").toString());
		int kintoB=Integer.parseInt(hokenryou.get(0).get("kinto2").toString());
		int kintoC=Integer.parseInt(hokenryou.get(0).get("kinto3").toString());

		//平均割
		int byodoA=Integer.parseInt(hokenryou.get(0).get("byodo1").toString());
		int byodoB=Integer.parseInt(hokenryou.get(0).get("byodo2").toString());;
		int byodoC=Integer.parseInt(hokenryou.get(0).get("byodo3").toString());;

		//所得の計算（年収から控除したあとの金額）。年収によって計算変わる。
		int shotoku160=-650000;
		double shotoku180=select1*10000*0.6;
		double shotoku360=select1*10000*0.7-180000-330000;
		double shotoku660=select1*10000*0.8-540000;
		double shotoku1000=select1*10000*0.9-1200000;

		//39歳以下の保険料
		int hokenryo160=(int) (shotoku160*(ryourituA+ryourituB)+kintoA+kintoB+byodoA+byodoB);
		int hokenryo180=(int) (shotoku180*(ryourituA+ryourituB)+kintoA+kintoB+byodoA+byodoB);
		int hokenryo360=(int) (shotoku360*(ryourituA+ryourituB)+kintoA+kintoB+byodoA+byodoB);
		int hokenryo660=(int) (shotoku660*(ryourituA+ryourituB)+kintoA+kintoB+byodoA+byodoB);
		int hokenryo1000=(int) (shotoku1000*(ryourituA+ryourituB)+kintoA+kintoB+byodoA+byodoB);

		//40歳以上の保険料(介護保険追加)
		int hokenryo160K=(int) (shotoku160*(ryourituA+ryourituB+ryourituC)+kintoA+kintoB+kintoC+byodoA+byodoB+byodoC);
		int hokenryo180K=(int) (shotoku180*(ryourituA+ryourituB+ryourituC)+kintoA+kintoB+kintoC+byodoA+byodoB+byodoC);
		int hokenryo360K=(int) (shotoku360*(ryourituA+ryourituB+ryourituC)+kintoA+kintoB+kintoC+byodoA+byodoB+byodoC);
		int hokenryo660K=(int) (shotoku660*(ryourituA+ryourituB+ryourituC)+kintoA+kintoB+kintoC+byodoA+byodoB+byodoC);
		int hokenryo1000K=(int) (shotoku1000*(ryourituA+ryourituB+ryourituC)+kintoA+kintoB+kintoC+byodoA+byodoB+byodoC);
        //System.err.println(hokenryo360);


		//年齢と年収による条件分岐プログラム
		//39歳以下の場合
		if(radio1==39) {
	switch(select1) {
		case 100:
		case 120:
		case 140:
			mav.addObject("msg","あなたの国民保険料は年額"+hokenryo160 + "円です");
			break;

		case 160:
		case 180:
			mav.addObject("msg","あなたの国民保険料は年額"+hokenryo180+"円です");
			break;

		case 200:
		case 250:
		case 300:
		case 350:
			mav.addObject("msg","あなたの国民保険料は年額"+hokenryo360+"円です");
			break;

		case 400:
		case 450:
		case 500:
		case 550:
		case 600:
		case 650:
			mav.addObject("msg","あなたの国民保険料は年額"+hokenryo660+"円です");
			break;

		case 700:
		case 750:
		case 800:
		case 850:
		case 900:
			mav.addObject("msg","あなたの国民保険料は年額"+hokenryo1000+"円です");
			break;
		}}

		//40歳以下の場合
		if(radio1==40) {
	    switch(select1) {
	    case 100:
		case 120:
		case 140:
			mav.addObject("msg","あなたの国民保険料は年額"+(hokenryo160K)+ "円です");
			break;

		case 160:
		case 180:
			mav.addObject("msg","あなたの国民保険料は年額"+hokenryo180K+"円です");
			break;

		case 200:
		case 250:
		case 300:
		case 350:
			mav.addObject("msg","あなたの国民保険料は年額"+hokenryo360K+"円です");
			break;

		case 400:
		case 450:
		case 500:
		case 550:
		case 600:
		case 650:
			mav.addObject("msg","あなたの国民保険料は年額"+hokenryo660K+"円です");
			break;

		case 700:
		case 750:
		case 800:
		case 850:
		case 900:
			mav.addObject("msg","あなたの国民保険料は年額"+hokenryo1000K+"円です");
			break;
		}}


		//テンプレート側の変数（左）に格納した配列変数（右）を保管する
		mav.setViewName("calc");
		//都道府県＆市町村名表示。パンくず。
		mav.addObject("pref_ja", HokkaidoController.pref_ja);
		mav.addObject("city_name", city_name);
		mav.addObject("pref_num", pref);
		return mav;
	}}









