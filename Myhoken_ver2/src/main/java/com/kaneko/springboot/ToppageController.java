package com.kaneko.springboot;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Takuya Kaneko
 *トップページ　都道府県選択クラス
 */
@Controller
public class ToppageController {

	//データベース接続に使うアノテーション。
	@Autowired
	JdbcTemplate jdbcTemplate;


	@RequestMapping("/")//URLと処理を関連付ける
	public ModelAndView index(ModelAndView mav){

           //使用するビューの名前(HTMLファイル名）を入力（テンプレート）
			mav.setViewName("index");

			//各地方の変数配列に都道府県をデータベースから抽出して配列に格納する。
			//thymeleafのeach文とインライン処理で埋め込んだ変数からHTML出力する。

			List<Map<String,Object>>hokkaido;
			hokkaido=jdbcTemplate.queryForList("select * from aria where id = 1");

			List<Map<String,Object>>touhoku;
			touhoku=jdbcTemplate.queryForList("select * from aria where id >=2 AND id <=7");

			List<Map<String,Object>>kantou;
			kantou=jdbcTemplate.queryForList("select * from aria where id >=8 AND id <=14");

			List<Map<String,Object>>hokuriku;
			hokuriku=jdbcTemplate.queryForList("select * from aria where id >=15 AND id <=20");

			List<Map<String,Object>>toukai;
			toukai=jdbcTemplate.queryForList("select * from aria where id >=21 AND id <=24");

			List<Map<String,Object>>kinki;
			kinki=jdbcTemplate.queryForList("select * from aria where id >=25 AND id <=30");

			List<Map<String,Object>>chugoku;
			chugoku=jdbcTemplate.queryForList("select * from aria where id >=31 AND id <=35");

			List<Map<String,Object>>sikoku;
			sikoku=jdbcTemplate.queryForList("select * from aria where id >=36 AND id <=39");


			List<Map<String,Object>>kyushu;
			kyushu=jdbcTemplate.queryForList("select * from aria where id >=40 AND id <=47");



			//テンプレート側の変数（左）に格納した配列変数（右）を保管する
            mav.addObject("hokkaido", hokkaido);
            mav.addObject("touhoku", touhoku);
            mav.addObject("kantou", kantou);
            mav.addObject("hokuriku", hokuriku);
            mav.addObject("toukai", toukai);
            mav.addObject("kinki", kinki);
            mav.addObject("chugoku", chugoku);
            mav.addObject("sikoku", sikoku);
            mav.addObject("kyushu", kyushu);

//
			return mav;
			}


	}
