package com.kaneko.springboot;

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
 */

@Controller
public class CalcController {

	//メソッドを指定してGETとPOSTを区別して書く。


	//URLのパラメータをnumで受け取り、numを使用するために@PathVariableをつける。
	@RequestMapping(value="/{num1}/{num2}/calc",method=RequestMethod.GET)
	public ModelAndView calc(ModelAndView mav,@PathVariable int num1,@PathVariable int num2){


			mav.setViewName("calc");
			mav.addObject("msg", "年齢を選んでください");
		//	mav.addObject("msg2", "昨年の年収を選んでください");
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


		//年齢と年収による条件分岐プログラム
		if(radio1==39) {
	switch(select1) {
		case 100:
			mav.addObject("msg","あなたの国民保険料は年額"+19660 + "円です");
			break;
		case 120:
			mav.addObject("msg","あなたの国民保険料は年額"+35160 +"円です");
			break;
		case 140:
			mav.addObject("msg","あなたの国民保険料は年額"+59120 +"円です");
			break;
		case 160:
			mav.addObject("msg","あなたの国民保険料は年額"+107500+"円です");
			break;
		case 180:
			mav.addObject("msg","あなたの国民保険料は年額"+139820+"円です");
			break;
		case 200:
			mav.addObject("msg","あなたの国民保険料は年額"+155390+"円です");
			break;
		case 250:
			mav.addObject("msg","あなたの国民保険料は年額"+172160+"円です");
			break;
		case 300:
			mav.addObject("msg","あなたの国民保険料は年額"+214100+"円です");
			break;
		case 350:
			mav.addObject("msg","あなたの国民保険料は年額"+256020+"円です");
			break;
		case 400:
			mav.addObject("msg","あなたの国民保険料は年額"+297960+"円です");
			break;
		case 450:
			mav.addObject("msg","あなたの国民保険料は年額"+344670+"円です");
			break;
		case 500:
			mav.addObject("msg","あなたの国民保険料は年額"+392590+"円です");
			break;
		case 550:
			mav.addObject("msg","あなたの国民保険料は年額"+440510+"円です");
			break;
		case 600:
			mav.addObject("msg","あなたの国民保険料は年額"+488430+"円です");
			break;
		case 650:
			mav.addObject("msg","あなたの国民保険料は年額"+536350+"円です");
			break;
		case 700:
			mav.addObject("msg","あなたの国民保険料は年額"+584270+"円です");
			break;
		case 750:
			mav.addObject("msg","あなたの国民保険料は年額"+636990+"円です");
			break;
		case 800:
			mav.addObject("msg","あなたの国民保険料は年額"+690900+"円です");
			break;
		case 850:
			mav.addObject("msg","あなたの国民保険料は年額"+723530+"円です");
			break;
		case 900:
			mav.addObject("msg","あなたの国民保険料は年額"+730000+"円です");
			break;
		}}

		if(radio1==40) {
	    switch(select1) {
		case 100:
			mav.addObject("msg","あなたの国民保険料は年額"+24490 +"円です");
			break;
		case 120:
			mav.addObject("msg","あなたの国民保険料は年額"+43850 +"円です");
			break;
		case 140:
			mav.addObject("msg","あなたの国民保険料は年額"+74210 +"円です");
			break;
		case 160:
			mav.addObject("msg","あなたの国民保険料は年額"+129070+"円です");
			break;
		case 180:
			mav.addObject("msg","あなたの国民保険料は年額"+175770+"円です");
			break;
		case 200:
			mav.addObject("msg","あなたの国民保険料は年額"+195500+"円です");
			break;
		case 250:
			mav.addObject("msg","あなたの国民保険料は年額"+216750+"円です");
			break;
		case 300:
			mav.addObject("msg","あなたの国民保険料は年額"+269890+"円です");
			break;
		case 350:
			mav.addObject("msg","あなたの国民保険料は年額"+323010+"円です");
			break;
		case 400:
			mav.addObject("msg","あなたの国民保険料は年額"+376150+"円です");
			break;
		case 450:
			mav.addObject("msg","あなたの国民保険料は年額"+435340+"円です");
			break;
		case 500:
			mav.addObject("msg","あなたの国民保険料は年額"+496060+"円です");
			break;
		case 550:
			mav.addObject("msg","あなたの国民保険料は年額"+556780+"円です");
			break;
		case 600:
			mav.addObject("msg","あなたの国民保険料は年額"+617500+"円です");
			break;
		case 650:
			mav.addObject("msg","あなたの国民保険料は年額"+678220+"円です");
			break;
		case 700:
			mav.addObject("msg","あなたの国民保険料は年額"+738940+"円です");
			break;
		case 750:
			mav.addObject("msg","あなたの国民保険料は年額"+796990+"円です");
			break;
		case 800:
			mav.addObject("msg","あなたの国民保険料は年額"+850900+"円です");
			break;
		case 850:
			mav.addObject("msg","あなたの国民保険料は年額"+883530+"円です");
			break;
		case 900:
			mav.addObject("msg","あなたの国民保険料は年額"+890000+"円です");
			break;
		}}


		//テンプレート側の変数（左）に格納した配列変数（右）を保管する
		mav.setViewName("calc");
		return mav;
	}}









