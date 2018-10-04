package com.kaneko.springboot;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kaneko.springboot.repositories.MyDataRepository;

/**
 * @author Takuya Kaneko
 *トップページ　都道府県選択クラス
 */
@Controller
public class ToppageController {

	//データベース接続に使うアノテーション。今は使わない。
	@Autowired
	MyDataRepository repository;

	@RequestMapping("/")//URLと処理を関連付ける
	public ModelAndView index(ModelAndView mav){

           //使用するビューの名前(HTMLファイル名）を入力（テンプレート）
			mav.setViewName("index");

			//各地方の変数配列に都道府県を格納する。
			//thymeleafのeach文とインライン処理で埋め込んだ変数からHTML出力する。
			ArrayList<Dataobject>hkd=new ArrayList<Dataobject>();
			hkd.add(new Dataobject (1,"北海道"));

			ArrayList<Dataobject>touhoku=new ArrayList<Dataobject>();
			touhoku.add(new Dataobject (2,"青森"));
			touhoku.add(new Dataobject (3,"岩手"));
			touhoku.add(new Dataobject (4,"宮城"));
			touhoku.add(new Dataobject (5,"秋田"));
			touhoku.add(new Dataobject (6,"山形"));
			touhoku.add(new Dataobject (7,"福島"));

			ArrayList<Dataobject>kantou=new ArrayList<Dataobject>();
			kantou.add(new Dataobject (8,"茨城"));
			kantou.add(new Dataobject (9,"栃木"));
			kantou.add(new Dataobject (10,"群馬"));
			kantou.add(new Dataobject (11,"埼玉"));
			kantou.add(new Dataobject (12,"千葉"));
			kantou.add(new Dataobject (13,"東京"));
			kantou.add(new Dataobject (14,"神奈川"));

			ArrayList<Dataobject>hokuriku=new ArrayList<Dataobject>();
			hokuriku.add(new Dataobject (15,"新潟"));
			hokuriku.add(new Dataobject (16,"富山"));
			hokuriku.add(new Dataobject (17,"石川"));
			hokuriku.add(new Dataobject (18,"福井"));
			hokuriku.add(new Dataobject (19,"山梨"));
			hokuriku.add(new Dataobject (20,"長野"));

			ArrayList<Dataobject>toukai=new ArrayList<Dataobject>();
			toukai.add(new Dataobject (21,"岐阜"));
			toukai.add(new Dataobject (22,"静岡"));
			toukai.add(new Dataobject (23,"愛知"));
			toukai.add(new Dataobject (24,"三重"));

			ArrayList<Dataobject>kinki=new ArrayList<Dataobject>();
			kinki.add(new Dataobject (25,"滋賀"));
			kinki.add(new Dataobject (26,"京都"));
			kinki.add(new Dataobject (27,"大阪"));
			kinki.add(new Dataobject (28,"兵庫"));
			kinki.add(new Dataobject (29,"奈良"));
			kinki.add(new Dataobject (30,"和歌山"));

			ArrayList<Dataobject>chugoku=new ArrayList<Dataobject>();
			chugoku.add(new Dataobject (31,"鳥取"));
			chugoku.add(new Dataobject (32,"島根"));
			chugoku.add(new Dataobject (33,"岡山"));
			chugoku.add(new Dataobject (34,"広島"));
			chugoku.add(new Dataobject (35,"山口"));

			ArrayList<Dataobject>sikoku=new ArrayList<Dataobject>();
			sikoku.add(new Dataobject (36,"徳島"));
			sikoku.add(new Dataobject (37,"香川"));
			sikoku.add(new Dataobject (38,"愛媛"));
			sikoku.add(new Dataobject (39,"高知"));


			ArrayList<Dataobject>kyushu=new ArrayList<Dataobject>();
			kyushu.add(new Dataobject (40,"福岡"));
			kyushu.add(new Dataobject (41,"佐賀"));
			kyushu.add(new Dataobject (42,"長崎"));
			kyushu.add(new Dataobject (43,"熊本"));
			kyushu.add(new Dataobject (44,"大分"));
			kyushu.add(new Dataobject (45,"宮崎"));
			kyushu.add(new Dataobject (46,"鹿児島"));
			kyushu.add(new Dataobject (47,"沖縄"));


			//テンプレート側の変数（左）に格納した配列変数（右）を保管する
            mav.addObject("hkd", hkd);
            mav.addObject("touhoku", touhoku);
            mav.addObject("kantou", kantou);
            mav.addObject("hokuriku", hokuriku);
            mav.addObject("toukai", toukai);
            mav.addObject("kinki", kinki);
            mav.addObject("chugoku", chugoku);
            mav.addObject("sikoku", sikoku);
            mav.addObject("kyushu", kyushu);

//			//JpaRepositoryのfindAllメソッドを使用
//			Iterable <MyData>list=repository.findAll();
//		    mav.addObject("data", list);
			return mav;
			}


	}
