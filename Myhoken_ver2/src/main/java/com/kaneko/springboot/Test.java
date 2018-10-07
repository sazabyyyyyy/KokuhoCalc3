package com.kaneko.springboot;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Takuya Kaneko
 *JDBCテスト用クラス
 */
@Controller
public class Test {


	@Autowired
	JdbcTemplate jdbcTemplate;

	@RequestMapping("/test")
	public String test1(Model model) {
		List<Map<String,Object>>list;
		list=jdbcTemplate.queryForList("select * from okinawa where id = 1");
		model.addAttribute("okinawa", list);
		return "test1";
	}

}
