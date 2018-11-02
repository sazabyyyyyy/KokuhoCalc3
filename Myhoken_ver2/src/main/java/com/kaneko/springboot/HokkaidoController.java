package com.kaneko.springboot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Takuya Kaneko
 *市町村選択クラス
 */
@Controller
public class HokkaidoController {

	//選択された県の市町村名を格納するリスト
	static List<Map<String,Object>>city_list;
	//選択された都道府県名を格納
	static String pref_ja;

	@Autowired
	JdbcTemplate jdbcTemplate;

//num=id 各都道府県のidを使ってデータベースから名前を取得して変数prefに格納したい @PathVariable int num
@RequestMapping("/a/{num}")// "/a/{num}"
	public ModelAndView city(ModelAndView mav, @PathVariable int num) {

	//DBから取得できないのでMapでやる。URLのnumとMapのキーを紐づけている
    Map<Integer,String>pref=new HashMap<>();
    pref.put( 1, "hokkaido");
    pref.put( 2, "aomori");
    pref.put( 3, "iwate");
    pref.put( 4, "miyagi");
    pref.put( 5, "akita");
    pref.put( 6, "yamagata");
    pref.put( 7, "fukushima");
    pref.put( 8, "ibaragi");
    pref.put( 9, "tochigi");
    pref.put(10, "gunma");
    pref.put(11, "saitama");
    pref.put(12, "chiba");
    pref.put(13, "tokyo");
    pref.put(14, "kanagawa");
    pref.put(15, "niigata");
    pref.put(16, "toyama");
    pref.put(17, "ishikawa");
    pref.put(18, "fukui");
    pref.put(19, "yamanashi");
    pref.put(20, "nagano");
    pref.put(21, "gifu");
    pref.put(22, "shizuoka");
    pref.put(23, "aichi");
    pref.put(24, "mie");
    pref.put(25, "shiga");
    pref.put(26, "kyoto");
    pref.put(27, "oosaka");
    pref.put(28, "hyougo");
    pref.put(29, "nara");
    pref.put(30, "wakayama");
    pref.put(31, "tottori");
    pref.put(32, "shimane");
    pref.put(33, "okayama");
    pref.put(34, "hiroshima");
    pref.put(35, "yamaguchi");
    pref.put(36, "tokushima");
    pref.put(37, "kagawa");
    pref.put(38, "ehime");
    pref.put(39, "kouchi");
    pref.put(40, "fukuoka");
    pref.put(41, "saga");
    pref.put(42, "nagasaki");
    pref.put(43, "kumamoto");
    pref.put(44, "ooita");
    pref.put(45, "miyazaki");
    pref.put(46, "kagoshima");
    pref.put(47, "okinawa");

	 //使用するビューの名前(HTMLファイル名）を入力（テンプレート）
		mav.setViewName("city");
		//ListにDBのデータを格納。num→Map→DBのid
		//Mapと同じものをDBから取得
		List<Map<String, Object>>aria=jdbcTemplate.queryForList("select * from aria2");
        //ariaからnumに紐づく県名を取得。配列なのでnum-1
		String pref2=aria.get(num-1).get("name").toString();
		System.err.println(pref2);
		//クエリに取得した県名の変数を使用.市町村一覧をリストに格納
		city_list=jdbcTemplate.queryForList("select * from "+pref2 );
		//なぜかここではpref2だと表示されない。上記のMapを使う。
		mav.addObject(pref.get(num), city_list);

		//HTML表示。選択に応じて都道府県名の表示が変わる。仕組みは上と同じ。
		//List<Map<String, Object>>aria_ja=jdbcTemplate.queryForList("select * from aria");
		pref_ja=ToppageController.zenkoku.get(num-1).get("name").toString();
		mav.addObject("pref_ja", pref_ja);

		return mav;

	}}


