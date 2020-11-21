package com.example.demo;

import org.springframework.web.bind.annotation.PathVariable;
//***下の文を使用するための事前準備***//
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller						
public class MainController {
@RequestMapping(value ="/",method = RequestMethod.GET)	
public ModelAndView indexGet(ModelAndView mv) {
	mv.addObject("name", "名前がここに入ります");
	mv.addObject("age", "年齢がここに入ります");
	mv.addObject("height", "身長がここに入ります");
	mv.setViewName("index");
	return mv;
}
@RequestMapping(value ="/",method = RequestMethod.POST)	
public ModelAndView indexPost(ModelAndView mv,@RequestParam("nameVal")String name,
@RequestParam("ageVal")String age, @RequestParam("heightVal")String height) {
	mv.addObject("name", name);
	mv.addObject("age", age);
	mv.addObject("height", height);
	mv.setViewName("index");
	return mv;	
}
@RequestMapping(value ="/day20",method = RequestMethod.GET)
public ModelAndView day20(ModelAndView mv) {
	mv.setViewName("day20_HW_index");
	mv.addObject("Value", "");
	return mv;
}

//入力した値（value）を受け取り、階乗計算をする
@RequestMapping(value ="/day20",method = RequestMethod.POST)
public ModelAndView day20(ModelAndView mv,@RequestParam("intVal")int value) {
	int factrial = value;
	value--;				// value = value - 1
	while (value > 0) {
		factrial = factrial * value;
		value--; 
	}
	int result = factrial;
	//計算結果を表示させるため、resultの値をHTMLへ返す。	
	mv.addObject("result", result);
	mv.setViewName("day20_HW_index");
	return mv;
}

//day21
@RequestMapping(value="/day21",method = RequestMethod.GET)
public ModelAndView day21GET(ModelAndView mv) {
	mv.addObject("suzuki",false);
	mv.setViewName("day21_text");
	return mv;
}
//入力フォーム（"${suzuki}" へ値を返して表示）
@RequestMapping(value="/day21",method = RequestMethod.POST)
public ModelAndView day21Post(ModelAndView mv,@RequestParam("inputVal")String value) {
	mv.addObject("suzuki",value);
	mv.setViewName("day21_text");	
	return mv;
}
//URLに値を入れる
@RequestMapping("/{num}")
public ModelAndView index(@PathVariable int num,ModelAndView mv) {
String line="";
for(int i=0; i<num; i++) line+="あ";
mv.addObject("suzuki", line);
mv.setViewName("day21_text");
return mv;
}



//day21_今日の宿題【素数判定マシーン】（URLに数字を入力するとその値が{number}に代入）
@RequestMapping("/{number}")
public ModelAndView day21HW_number(@PathVariable int num,ModelAndView mv) {
String line="";
mv.addObject("number", line);
mv.setViewName("day21HW_number");
return mv;
}


//day22_HTMLの繰り返し
@RequestMapping(value="/day22_index")
public ModelAndView indexPost(ModelAndView mv) {
	ArrayList<String[]>customers = new ArrayList<String[]>();
	customers.add(new String[] {"佐藤HTML太郎","35歳","男性","東京"});
	customers.add(new String[] {"鈴木Java五郎","24歳","男性","大阪"});
	customers.add(new String[] {"高橋CSS子","29歳","女性","福岡"});
	customers.add(new String[] {"西田 PHP子","25歳","女性","仙台"});
	customers.add(new String[] {"矢野 SQL子","30歳","女性","札幌"});
	mv.addObject("customers", customers);
	mv.setViewName("day22_index");
	return mv;
}

}