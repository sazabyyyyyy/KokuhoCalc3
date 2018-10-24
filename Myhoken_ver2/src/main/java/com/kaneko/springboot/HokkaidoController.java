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

	@Autowired
	JdbcTemplate jdbcTemplate;

//num=id 各都道府県のidを使ってデータベースから名前を取得して変数prefに格納したい @PathVariable int num
@RequestMapping("/a/{num}")// "/a/{num}"
	public ModelAndView city(ModelAndView mav, @PathVariable int num) {

	//DBから取得できないのでMapでやる。URLのnumとMapのキーを紐づけている
     Map<Integer,String>pref=new HashMap<>();
     pref.put( 1, "hokkaido");
     pref.put( 2, "aomori");
     pref.put( 3, "iwate ");
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
		List<Map<String,Object>>list=jdbcTemplate.queryForList("select * from " +pref.get(num));
		mav.addObject(pref.get(num), list);
		return mav;

	}}
//
//@RequestMapping("/2")
//public ModelAndView city2(ModelAndView mav) {
//	// TODO 自動生成されたメソッド・スタブ
//
// //使用するビューの名前(HTMLファイル名）を入力（テンプレート）
//	mav.setViewName("city");
//	List<Map<String,Object>>list;
//	list=jdbcTemplate.queryForList("select * from aomori");
//	//テンプレート側の変数（左）に格納した配列変数（右）を保管する
//	mav.addObject("aomori", list);
//	return mav;
//}
//
//@RequestMapping("/3")
//public ModelAndView city3(ModelAndView mav) {
//	// TODO 自動生成されたメソッド・スタブ
//
// //使用するビューの名前(HTMLファイル名）を入力（テンプレート）
//	mav.setViewName("city");
//	List<Map<String,Object>>list;
//	list=jdbcTemplate.queryForList("select * from iwate");
//	//テンプレート側の変数（左）に格納した配列変数（右）を保管する
//	mav.addObject("iwate", list);
//	return mav;
//}
//
//@RequestMapping("/4")
//public ModelAndView city4(ModelAndView mav) {
//	mav.setViewName("city");
//	List<Map<String,Object>>list;
//	list=jdbcTemplate.queryForList("select * from miyagi ");
//	mav.addObject("miyagi", list);
//	return mav;
//}
//@RequestMapping("/5")
//public ModelAndView city5(ModelAndView mav) {
//	mav.setViewName("city");
//	List<Map<String,Object>>list;
//	list=jdbcTemplate.queryForList("select * from akita");
//	mav.addObject("akita", list);
//	return mav;
//}
//@RequestMapping("/6")
//public ModelAndView city6(ModelAndView mav) {
//	mav.setViewName("city");
//	List<Map<String,Object>>list;
//	list=jdbcTemplate.queryForList("select * from yamagata");
//	mav.addObject("yamagata", list);
//	return mav;
//}
//@RequestMapping("/7")
//public ModelAndView city7(ModelAndView mav) {
//	mav.setViewName("city");
//	List<Map<String,Object>>list;
//	list=jdbcTemplate.queryForList("select * from fukushima");
//	mav.addObject("fukushima", list);
//	return mav;
//}
//@RequestMapping("/8")
//public ModelAndView city8(ModelAndView mav) {
//	mav.setViewName("city");
//	List<Map<String,Object>>list;
//	list=jdbcTemplate.queryForList("select * from ibaragi");
//	mav.addObject("ibaragi", list);
//	return mav;
//}
//@RequestMapping("/9")
//public ModelAndView city9(ModelAndView mav) {
//	mav.setViewName("city");
//	List<Map<String,Object>>list;
//	list=jdbcTemplate.queryForList("select * from tochigi");
//	mav.addObject("tochigi", list);
//	return mav;
//}
//@RequestMapping("/10")
//public ModelAndView city10(ModelAndView mav) {
//	mav.setViewName("city");
//	List<Map<String,Object>>list;
//	list=jdbcTemplate.queryForList("select * from  gunma ");
//	mav.addObject("gunma", list);
//	return mav;
//}
//@RequestMapping("/11")
//public ModelAndView city11(ModelAndView mav) {
//	mav.setViewName("city");
//	List<Map<String,Object>>list;
//	list=jdbcTemplate.queryForList("select * from saitama");
//	mav.addObject("saitama", list);
//	return mav;
//}
//@RequestMapping("/12")
//public ModelAndView city12(ModelAndView mav) {
//	mav.setViewName("city");
//	List<Map<String,Object>>list;
//	list=jdbcTemplate.queryForList("select * from chiba");
//	mav.addObject("chiba", list);
//	return mav;
//}
//@RequestMapping("/13")
//public ModelAndView city13(ModelAndView mav) {
//	mav.setViewName("city");
//	List<Map<String,Object>>list;
//	list=jdbcTemplate.queryForList("select * from tokyo");
//	mav.addObject("tokyo", list);
//	return mav;
//}
//@RequestMapping("/14")
//public ModelAndView city14(ModelAndView mav) {
//	mav.setViewName("city");
//	List<Map<String,Object>>list;
//	list=jdbcTemplate.queryForList("select * from kanagawa");
//	mav.addObject("kanagawa", list);
//	return mav;
//}
//@RequestMapping("/15")
//public ModelAndView city15(ModelAndView mav) {
//	mav.setViewName("city");
//	List<Map<String,Object>>list;
//	list=jdbcTemplate.queryForList("select * from niigata");
//	mav.addObject("niigata", list);
//	return mav;
//}
//@RequestMapping("/16")
//public ModelAndView city16(ModelAndView mav) {
//	mav.setViewName("city");
//	List<Map<String,Object>>list;
//	list=jdbcTemplate.queryForList("select * from toyama");
//	mav.addObject("toyama", list);
//	return mav;
//}
//@RequestMapping("/17")
//public ModelAndView city17(ModelAndView mav) {
//	mav.setViewName("city");
//	List<Map<String,Object>>list;
//	list=jdbcTemplate.queryForList("select * from ishikawa");
//	mav.addObject("ishikawa", list);
//	return mav;
//}
//@RequestMapping("/18")
//public ModelAndView city18(ModelAndView mav) {
//	mav.setViewName("city");
//	List<Map<String,Object>>list;
//	list=jdbcTemplate.queryForList("select * from fukui");
//	mav.addObject("fukui", list);
//	return mav;
//}
//@RequestMapping("/19")
//public ModelAndView city19(ModelAndView mav) {
//	mav.setViewName("city");
//	List<Map<String,Object>>list;
//	list=jdbcTemplate.queryForList("select * from yamanashi");
//	mav.addObject("yamanashi", list);
//	return mav;
//}
//@RequestMapping("/20")
//public ModelAndView city20(ModelAndView mav) {
//	mav.setViewName("city");
//	List<Map<String,Object>>list;
//	list=jdbcTemplate.queryForList("select * from nagano");
//	mav.addObject("nagano", list);
//	return mav;
//}
//@RequestMapping("/21")
//public ModelAndView city21(ModelAndView mav) {
//	mav.setViewName("city");
//	List<Map<String,Object>>list;
//	list=jdbcTemplate.queryForList("select * from gifu");
//	mav.addObject("gifu", list);
//	return mav;
//}
//@RequestMapping("/22")
//public ModelAndView city22(ModelAndView mav) {
//	mav.setViewName("city");
//	List<Map<String,Object>>list;
//	list=jdbcTemplate.queryForList("select * from shizuoka");
//	mav.addObject("shizuoka", list);
//	return mav;
//}
//@RequestMapping("/23")
//public ModelAndView city23(ModelAndView mav) {
//	mav.setViewName("city");
//	List<Map<String,Object>>list;
//	list=jdbcTemplate.queryForList("select * from aichi");
//	mav.addObject("aichi", list);
//	return mav;
//}
//@RequestMapping("/24")
//public ModelAndView city24(ModelAndView mav) {
//	mav.setViewName("city");
//	List<Map<String,Object>>list;
//	list=jdbcTemplate.queryForList("select * from mie");
//	mav.addObject("mie", list);
//	return mav;
//}
//@RequestMapping("/25")
//public ModelAndView city25(ModelAndView mav) {
//	mav.setViewName("city");
//	List<Map<String,Object>>list;
//	list=jdbcTemplate.queryForList("select * from shiga");
//	mav.addObject("shiga", list);
//	return mav;
//}
//@RequestMapping("/26")
//public ModelAndView city26(ModelAndView mav) {
//	mav.setViewName("city");
//	List<Map<String,Object>>list;
//	list=jdbcTemplate.queryForList("select * from kyoto");
//	mav.addObject("kyoto", list);
//	return mav;
//}
//@RequestMapping("/27")
//public ModelAndView city27(ModelAndView mav) {
//	mav.setViewName("city");
//	List<Map<String,Object>>list;
//	list=jdbcTemplate.queryForList("select * from oosaka");
//	mav.addObject("oosaka", list);
//	return mav;
//}
//@RequestMapping("/28")
//public ModelAndView city28(ModelAndView mav) {
//	mav.setViewName("city");
//	List<Map<String,Object>>list;
//	list=jdbcTemplate.queryForList("select * from hyougo");
//	mav.addObject("hyougo", list);
//	return mav;
//}
//@RequestMapping("/29")
//public ModelAndView city29(ModelAndView mav) {
//	mav.setViewName("city");
//	List<Map<String,Object>>list;
//	list=jdbcTemplate.queryForList("select * from nara");
//	mav.addObject("nara", list);
//	return mav;
//}
//@RequestMapping("/30")
//public ModelAndView city30(ModelAndView mav) {
//	mav.setViewName("city");
//	List<Map<String,Object>>list;
//	list=jdbcTemplate.queryForList("select * from wakayama");
//	mav.addObject("wakayama", list);
//	return mav;
//}
//@RequestMapping("/31")
//public ModelAndView city31(ModelAndView mav) {
//	mav.setViewName("city");
//	List<Map<String,Object>>list;
//	list=jdbcTemplate.queryForList("select * from tottori");
//	mav.addObject("tottori", list);
//	return mav;
//}
//@RequestMapping("/32")
//public ModelAndView city32(ModelAndView mav) {
//	mav.setViewName("city");
//	List<Map<String,Object>>list;
//	list=jdbcTemplate.queryForList("select * from shimane");
//	mav.addObject("shimane", list);
//	return mav;
//}
//@RequestMapping("/33")
//public ModelAndView city33(ModelAndView mav) {
//	mav.setViewName("city");
//	List<Map<String,Object>>list;
//	list=jdbcTemplate.queryForList("select * from okayama");
//	mav.addObject("okayama", list);
//	return mav;
//}
//@RequestMapping("/34")
//public ModelAndView city34(ModelAndView mav) {
//	mav.setViewName("city");
//	List<Map<String,Object>>list;
//	list=jdbcTemplate.queryForList("select * from hiroshima");
//	mav.addObject("hiroshima", list);
//	return mav;
//}
//@RequestMapping("/35")
//public ModelAndView city35(ModelAndView mav) {
//	mav.setViewName("city");
//	List<Map<String,Object>>list;
//	list=jdbcTemplate.queryForList("select * from yamaguchi");
//	mav.addObject("yamaguchi", list);
//	return mav;
//}
//@RequestMapping("/36")
//public ModelAndView city36(ModelAndView mav) {
//	mav.setViewName("city");
//	List<Map<String,Object>>list;
//	list=jdbcTemplate.queryForList("select * from tokushima");
//	mav.addObject("tokushima", list);
//	return mav;
//}
//@RequestMapping("/37")
//public ModelAndView city37(ModelAndView mav) {
//	mav.setViewName("city");
//	List<Map<String,Object>>list;
//	list=jdbcTemplate.queryForList("select * from kagawa");
//	mav.addObject("kagawa", list);
//	return mav;
//}
//@RequestMapping("/38")
//public ModelAndView city38(ModelAndView mav) {
//	mav.setViewName("city");
//	List<Map<String,Object>>list;
//	list=jdbcTemplate.queryForList("select * from ehime");
//	mav.addObject("ehime", list);
//	return mav;
//}
//@RequestMapping("/39")
//public ModelAndView city39(ModelAndView mav) {
//	mav.setViewName("city");
//	List<Map<String,Object>>list;
//	list=jdbcTemplate.queryForList("select * from kouchi");
//	mav.addObject("kouchi", list);
//	return mav;
//}
//@RequestMapping("/40")
//public ModelAndView city40(ModelAndView mav) {
//	mav.setViewName("city");
//	List<Map<String,Object>>list;
//	list=jdbcTemplate.queryForList("select * from fukuoka");
//	mav.addObject("fukuoka", list);
//	return mav;
//}
//@RequestMapping("/41")
//public ModelAndView city41(ModelAndView mav) {
//	mav.setViewName("city");
//	List<Map<String,Object>>list;
//	list=jdbcTemplate.queryForList("select * from saga");
//	mav.addObject("saga", list);
//	return mav;
//}
//@RequestMapping("/42")
//public ModelAndView city42(ModelAndView mav) {
//	mav.setViewName("city");
//	List<Map<String,Object>>list;
//	list=jdbcTemplate.queryForList("select * from nagasaki");
//	mav.addObject("nagasaki", list);
//	return mav;
//}
//@RequestMapping("/43")
//public ModelAndView city43(ModelAndView mav) {
//	mav.setViewName("city");
//	List<Map<String,Object>>list;
//	list=jdbcTemplate.queryForList("select * from kumamoto");
//	mav.addObject("kumamoto", list);
//	return mav;
//}
//@RequestMapping("/46")
//public ModelAndView city44(ModelAndView mav) {
//	mav.setViewName("city");
//	List<Map<String,Object>>list;
//	list=jdbcTemplate.queryForList("select * from kagoshima");
//	mav.addObject("kagoshima", list);
//	return mav;
//}
//@RequestMapping("/44")
//public ModelAndView city45(ModelAndView mav) {
//	mav.setViewName("city");
//	List<Map<String,Object>>list;
//	list=jdbcTemplate.queryForList("select * from ooita");
//	mav.addObject("ooita", list);
//	return mav;
//}
//@RequestMapping("/45")
//public ModelAndView city46(ModelAndView mav) {
//	mav.setViewName("city");
//	List<Map<String,Object>>list;
//	list=jdbcTemplate.queryForList("select * from miyazaki");
//	mav.addObject("miyazaki", list);
//	return mav;
//}
//@RequestMapping("/47")
//public ModelAndView city47(ModelAndView mav) {
//	mav.setViewName("city");
//	List<Map<String,Object>>list;
//	list=jdbcTemplate.queryForList("select * from okinawa");
//	mav.addObject("okinawa", list);
//	return mav;
//}

