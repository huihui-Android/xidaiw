package xidaiw.licai.bean;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class LoanPageAdapter {
	/**
	 * code : 1
	 * data : {"list":[{"activityDescription":"","appshouDesciption":"app","baseAmount":100,"canJoin":true,"canJoinCode":0,"cornerType":"TASTE","descriptionTitle":"车辆抵押","endBuyTime":"24时0分","finishRatio":70,"id":605,"idStr":"eeeegqq9k","interest":14,"maturityDuration":"10天","maxAmount":100,"maxInterest":14,"minAmount":1,"minInterest":14,"normalInterest":14,"productChannelId":2,"productInterestType":"固定收益","productName":"比亚迪抵押借款 第389期","productStatus":"SALES","productStatusValue":"销售中","productTypeName":"短期体验产品","productTypeValue":"SHORT_TASTE_PRODUCT","recommend":false,"remainingAmount":30,"saleAmount":70,"saleEndTime":"2018-02-07 00:00:00","saleStartTime":"2018-02-04 13:27:36","startBuyTime":"0时0分","totalAmount":10000,"totalBuyNumber":7,"totalCopies":100},{"activityDescription":"","appshouDesciption":"app","awardInterest":3,"baseAmount":100,"canJoin":true,"canJoinCode":0,"cornerType":"ACTIVITY","descriptionTitle":"车辆抵押","endBuyTime":"24时0分","finishRatio":0,"id":609,"idStr":"WWWWRWZ2f","interest":12.8,"maturityDuration":"180天","maxAmount":650,"maxInterest":12.8,"minAmount":1,"minInterest":12.8,"normalInterest":9.8,"productChannelId":2,"productInterestType":"固定收益","productName":"丰田抵押借款 第393期","productStatus":"SALES","productStatusValue":"销售中","productTypeName":"常规固定期限产品","productTypeValue":"FIXED_TERM_PRODUCT","recommend":false,"remainingAmount":650,"saleAmount":0,"saleEndTime":"2018-02-08 00:00:00","saleStartTime":"2018-02-05 11:13:39","startBuyTime":"0时0分","totalAmount":65000,"totalBuyNumber":0,"totalCopies":650},{"activityDescription":"","appshouDesciption":"app","awardInterest":3,"baseAmount":100,"canJoin":true,"canJoinCode":0,"cornerType":"ACTIVITY","descriptionTitle":"车辆抵押","endBuyTime":"24时0分","finishRatio":0,"id":608,"idStr":"SSSSXST44","interest":10.8,"maturityDuration":"90天","maxAmount":600,"maxInterest":10.8,"minAmount":1,"minInterest":10.8,"normalInterest":7.800000000000001,"productChannelId":2,"productInterestType":"固定收益","productName":"东风日产抵押借款 第392期","productStatus":"SALES","productStatusValue":"销售中","productTypeName":"常规固定期限产品","productTypeValue":"FIXED_TERM_PRODUCT","recommend":false,"remainingAmount":600,"saleAmount":0,"saleEndTime":"2018-02-08 00:00:00","saleStartTime":"2018-02-05 11:05:54","startBuyTime":"0时0分","totalAmount":60000,"totalBuyNumber":0,"totalCopies":600},{"activityDescription":"","appshouDesciption":"app","awardInterest":3,"baseAmount":100,"canJoin":true,"canJoinCode":0,"cornerType":"ACTIVITY","descriptionTitle":"车辆抵押","endBuyTime":"24时0分","finishRatio":0,"id":607,"idStr":"BBBBtBDfb","interest":9.8,"maturityDuration":"60天","maxAmount":900,"maxInterest":9.8,"minAmount":1,"minInterest":9.8,"normalInterest":6.800000000000001,"productChannelId":2,"productInterestType":"固定收益","productName":"丰田抵押借款 第391期","productStatus":"SALES","productStatusValue":"销售中","productTypeName":"常规固定期限产品","productTypeValue":"FIXED_TERM_PRODUCT","recommend":false,"remainingAmount":900,"saleAmount":0,"saleEndTime":"2018-02-08 00:00:00","saleStartTime":"2018-02-05 10:57:25","startBuyTime":"0时0分","totalAmount":90000,"totalBuyNumber":0,"totalCopies":900},{"activityDescription":"","appshouDesciption":"app","awardInterest":3,"baseAmount":100,"canJoin":true,"canJoinCode":0,"cornerType":"ACTIVITY","descriptionTitle":"车辆抵押","endBuyTime":"24时0分","finishRatio":61.54,"id":611,"idStr":"BBBBRBA1f","interest":7.8,"maturityDuration":"30天","maxAmount":1300,"maxInterest":7.8,"minAmount":1,"minInterest":7.8,"normalInterest":4.8,"productChannelId":2,"productInterestType":"固定收益","productName":"奥迪抵押借款 第395期","productStatus":"SALES","productStatusValue":"销售中","productTypeName":"常规固定期限产品","productTypeValue":"FIXED_TERM_PRODUCT","recommend":false,"remainingAmount":500,"saleAmount":800,"saleEndTime":"2018-02-08 00:00:00","saleStartTime":"2018-02-05 14:16:44","startBuyTime":"0时0分","totalAmount":130000,"totalBuyNumber":1,"totalCopies":1300},{"activityDescription":"","appshouDesciption":"app","awardInterest":5.5,"baseAmount":100,"canJoin":true,"canJoinCode":0,"cornerType":"CLOSED","descriptionTitle":"车辆抵押","endBuyTime":"24时0分","finishRatio":100,"id":44,"idStr":"bbbbbZl35","interest":18.8,"maturityDuration":"3天","maxAmount":10,"maxInterest":18.8,"minAmount":1,"minInterest":18.8,"normalInterest":13.3,"passTime":"2017-07-07 18:32:49","productChannelId":2,"productInterestType":"固定收益","productName":"奥迪抵押借款","productStatus":"ENDED","productStatusValue":"已结束","productTypeName":"常规固定期限产品","productTypeValue":"FIXED_TERM_PRODUCT","recommend":false,"remainingAmount":0,"saleAmount":300,"saleEndTime":"2017-07-07 00:00:00","saleStartTime":"2017-07-04 14:43:36","startBuyTime":"0时0分","startInterestDate":"2017-07-07","totalAmount":30000,"totalBuyNumber":13,"totalCopies":300},{"activityDescription":"","appshouDesciption":"app","baseAmount":100,"canJoin":true,"canJoinCode":0,"cornerType":"CLOSED","descriptionTitle":"车辆抵押","endBuyTime":"24时0分","finishRatio":100,"id":270,"idStr":"eeeeatx49","interest":16,"maturityDuration":"3天","maxAmount":50,"maxInterest":16,"minAmount":1,"minInterest":16,"normalInterest":16,"passTime":"2017-09-26 09:14:29","productChannelId":2,"productInterestType":"固定收益","productName":"现代伊兰特抵押借款 第115期","productStatus":"ENDED","productStatusValue":"已结束","productTypeName":"短期体验产品","productTypeValue":"SHORT_TASTE_PRODUCT","recommend":false,"remainingAmount":0,"saleAmount":300,"saleEndTime":"2017-09-23 00:00:00","saleStartTime":"2017-09-20 15:49:10","startBuyTime":"0时0分","startInterestDate":"2017-09-26","totalAmount":30000,"totalBuyNumber":2,"totalCopies":300},{"activityDescription":"","appshouDesciption":"app","baseAmount":100,"canJoin":true,"canJoinCode":0,"cornerType":"CLOSED","descriptionTitle":"车辆抵押","endBuyTime":"24时0分","finishRatio":100,"id":264,"idStr":"WWWWvgk30","interest":16,"maturityDuration":"3天","maxAmount":50,"maxInterest":16,"minAmount":1,"minInterest":16,"normalInterest":16,"passTime":"2017-09-21 09:05:46","productChannelId":2,"productInterestType":"固定收益","productName":"日产轩逸抵押借款 第110期","productStatus":"ENDED","productStatusValue":"已结束","productTypeName":"短期体验产品","productTypeValue":"SHORT_TASTE_PRODUCT","recommend":false,"remainingAmount":0,"saleAmount":300,"saleEndTime":"2017-09-21 00:00:00","saleStartTime":"2017-09-18 16:34:04","startBuyTime":"0时0分","startInterestDate":"2017-09-21","totalAmount":30000,"totalBuyNumber":3,"totalCopies":300},{"activityDescription":"","appshouDesciption":"app","baseAmount":100,"canJoin":true,"canJoinCode":0,"cornerType":"CLOSED","descriptionTitle":"车辆抵押","endBuyTime":"24时0分","finishRatio":100,"id":242,"idStr":"WWWWvctd6","interest":16,"maturityDuration":"3天","maxAmount":50,"maxInterest":16,"minAmount":1,"minInterest":16,"normalInterest":16,"passTime":"2017-09-14 09:04:24","productChannelId":2,"productInterestType":"固定收益","productName":"丰田凯美瑞抵押借款 第95期","productStatus":"ENDED","productStatusValue":"已结束","productTypeName":"短期体验产品","productTypeValue":"SHORT_TASTE_PRODUCT","recommend":false,"remainingAmount":0,"saleAmount":500,"saleEndTime":"2017-09-11 00:00:00","saleStartTime":"2017-09-08 16:07:22","startBuyTime":"0时0分","startInterestDate":"2017-09-14","totalAmount":50000,"totalBuyNumber":2,"totalCopies":500},{"activityDescription":"","appshouDesciption":"app","baseAmount":100,"canJoin":true,"canJoinCode":0,"cornerType":"CLOSED","descriptionTitle":"车辆抵押","endBuyTime":"24时0分","finishRatio":100,"id":226,"idStr":"bbbbTTbb5","interest":16,"maturityDuration":"3天","maxAmount":50,"maxInterest":16,"minAmount":1,"minInterest":16,"normalInterest":16,"passTime":"2017-09-09 08:12:34","productChannelId":2,"productInterestType":"固定收益","productName":"大众捷达抵押借款 第87期","productStatus":"ENDED","productStatusValue":"已结束","productTypeName":"短期体验产品","productTypeValue":"SHORT_TASTE_PRODUCT","recommend":false,"remainingAmount":0,"saleAmount":300,"saleEndTime":"2017-09-08 00:00:00","saleStartTime":"2017-09-05 17:14:57","startBuyTime":"0时0分","startInterestDate":"2017-09-09","totalAmount":30000,"totalBuyNumber":2,"totalCopies":300}],"list1":[{"activityDescription":"","appshouDesciption":"app","awardInterest":3,"baseAmount":100,"canJoin":true,"canJoinCode":0,"cornerType":"ACTIVITY","descriptionTitle":"车辆抵押","endBuyTime":"24时0分","finishRatio":61.54,"id":611,"idStr":"SSSSoSg1f","interest":7.8,"maturityDuration":"30天","maxAmount":1300,"maxInterest":7.8,"minAmount":1,"minInterest":7.8,"normalInterest":4.8,"productChannelId":2,"productInterestType":"固定收益","productName":"奥迪抵押借款 第395期","productStatus":"SALES","productStatusValue":"销售中","productTypeName":"常规固定期限产品","productTypeValue":"FIXED_TERM_PRODUCT","recommend":false,"remainingAmount":500,"saleAmount":800,"saleEndTime":"2018-02-08 00:00:00","saleStartTime":"2018-02-05 14:16:44","startBuyTime":"0时0分","totalAmount":130000,"totalBuyNumber":1,"totalCopies":1300},{"activityDescription":"","appshouDesciption":"app","awardInterest":3,"baseAmount":100,"canJoin":true,"canJoinCode":0,"cornerType":"ACTIVITY","descriptionTitle":"车辆抵押","endBuyTime":"24时0分","finishRatio":0,"id":609,"idStr":"SSSSoSc2f","interest":12.8,"maturityDuration":"180天","maxAmount":650,"maxInterest":12.8,"minAmount":1,"minInterest":12.8,"normalInterest":9.8,"productChannelId":2,"productInterestType":"固定收益","productName":"丰田抵押借款 第393期","productStatus":"SALES","productStatusValue":"销售中","productTypeName":"常规固定期限产品","productTypeValue":"FIXED_TERM_PRODUCT","recommend":false,"remainingAmount":650,"saleAmount":0,"saleEndTime":"2018-02-08 00:00:00","saleStartTime":"2018-02-05 11:13:39","startBuyTime":"0时0分","totalAmount":65000,"totalBuyNumber":0,"totalCopies":650},{"activityDescription":"","appshouDesciption":"app","awardInterest":3,"baseAmount":100,"canJoin":true,"canJoinCode":0,"cornerType":"ACTIVITY","descriptionTitle":"车辆抵押","endBuyTime":"24时0分","finishRatio":0,"id":608,"idStr":"BBBBzBv44","interest":10.8,"maturityDuration":"90天","maxAmount":600,"maxInterest":10.8,"minAmount":1,"minInterest":10.8,"normalInterest":7.800000000000001,"productChannelId":2,"productInterestType":"固定收益","productName":"东风日产抵押借款 第392期","productStatus":"SALES","productStatusValue":"销售中","productTypeName":"常规固定期限产品","productTypeValue":"FIXED_TERM_PRODUCT","recommend":false,"remainingAmount":600,"saleAmount":0,"saleEndTime":"2018-02-08 00:00:00","saleStartTime":"2018-02-05 11:05:54","startBuyTime":"0时0分","totalAmount":60000,"totalBuyNumber":0,"totalCopies":600},{"activityDescription":"","appshouDesciption":"app","awardInterest":3,"baseAmount":100,"canJoin":true,"canJoinCode":0,"cornerType":"ACTIVITY","descriptionTitle":"车辆抵押","endBuyTime":"24时0分","finishRatio":0,"id":607,"idStr":"WWWWoWYfb","interest":9.8,"maturityDuration":"60天","maxAmount":900,"maxInterest":9.8,"minAmount":1,"minInterest":9.8,"normalInterest":6.800000000000001,"productChannelId":2,"productInterestType":"固定收益","productName":"丰田抵押借款 第391期","productStatus":"SALES","productStatusValue":"销售中","productTypeName":"常规固定期限产品","productTypeValue":"FIXED_TERM_PRODUCT","recommend":false,"remainingAmount":900,"saleAmount":0,"saleEndTime":"2018-02-08 00:00:00","saleStartTime":"2018-02-05 10:57:25","startBuyTime":"0时0分","totalAmount":90000,"totalBuyNumber":0,"totalCopies":900},{"activityDescription":"","appshouDesciption":"app","baseAmount":100,"canJoin":true,"canJoinCode":0,"cornerType":"TASTE","descriptionTitle":"车辆抵押","endBuyTime":"24时0分","finishRatio":70,"id":605,"idStr":"SSSSjqq9k","interest":14,"maturityDuration":"10天","maxAmount":100,"maxInterest":14,"minAmount":1,"minInterest":14,"normalInterest":14,"productChannelId":2,"productInterestType":"固定收益","productName":"比亚迪抵押借款 第389期","productStatus":"SALES","productStatusValue":"销售中","productTypeName":"短期体验产品","productTypeValue":"SHORT_TASTE_PRODUCT","recommend":false,"remainingAmount":30,"saleAmount":70,"saleEndTime":"2018-02-07 00:00:00","saleStartTime":"2018-02-04 13:27:36","startBuyTime":"0时0分","totalAmount":10000,"totalBuyNumber":7,"totalCopies":100},{"activityDescription":"","appshouDesciption":"app","awardInterest":3,"baseAmount":100,"canJoin":true,"canJoinCode":0,"cornerType":"SALE_OVER","descriptionTitle":"车辆抵押","endBuyTime":"24时0分","finishRatio":100,"id":610,"idStr":"WWWWoWQ74","interest":7.8,"maturityDuration":"30天","maxAmount":2000,"maxInterest":7.8,"minAmount":1,"minInterest":7.8,"normalInterest":4.8,"productChannelId":2,"productInterestType":"固定收益","productName":"奔驰抵押借款 第394期","productStatus":"SALES_OVER","productStatusValue":"售罄","productTypeName":"常规固定期限产品","productTypeValue":"FIXED_TERM_PRODUCT","recommend":false,"remainingAmount":0,"saleAmount":2000,"saleEndTime":"2018-02-08 00:00:00","saleStartTime":"2018-02-05 11:44:15","startBuyTime":"0时0分","totalAmount":200000,"totalBuyNumber":5,"totalCopies":2000},{"activityDescription":"","appshouDesciption":"app","awardInterest":3,"baseAmount":100,"canJoin":true,"canJoinCode":0,"cornerType":"SALE_OVER","descriptionTitle":"车辆抵押","endBuyTime":"24时0分","finishRatio":100,"id":606,"idStr":"bbbbobbdk","interest":7.8,"maturityDuration":"30天","maxAmount":2000,"maxInterest":7.8,"minAmount":1,"minInterest":7.8,"normalInterest":4.8,"productChannelId":2,"productInterestType":"固定收益","productName":"宝马抵押借款 第390期","productStatus":"SALES_OVER","productStatusValue":"售罄","productTypeName":"常规固定期限产品","productTypeValue":"FIXED_TERM_PRODUCT","recommend":false,"remainingAmount":0,"saleAmount":2000,"saleEndTime":"2018-02-08 00:00:00","saleStartTime":"2018-02-05 09:44:39","startBuyTime":"0时0分","totalAmount":200000,"totalBuyNumber":4,"totalCopies":2000},{"activityDescription":"","appshouDesciption":"app","awardInterest":3,"baseAmount":100,"canJoin":true,"canJoinCode":0,"cornerType":"SALE_OVER","descriptionTitle":"车辆抵押","endBuyTime":"24时0分","finishRatio":100,"id":604,"idStr":"WWWWVMlk0","interest":7.8,"maturityDuration":"30天","maxAmount":2000,"maxInterest":7.8,"minAmount":1,"minInterest":7.8,"normalInterest":4.8,"productChannelId":2,"productInterestType":"固定收益","productName":"宝马抵押借款 第388期","productStatus":"SALES_OVER","productStatusValue":"售罄","productTypeName":"常规固定期限产品","productTypeValue":"FIXED_TERM_PRODUCT","recommend":false,"remainingAmount":0,"saleAmount":2000,"saleEndTime":"2018-02-05 00:00:00","saleStartTime":"2018-02-02 12:21:57","startBuyTime":"0时0分","totalAmount":200000,"totalBuyNumber":3,"totalCopies":2000},{"activityDescription":"","appshouDesciption":"app","awardInterest":3,"baseAmount":100,"canJoin":true,"canJoinCode":0,"cornerType":"SALE_OVER","descriptionTitle":"车辆抵押","endBuyTime":"24时0分","finishRatio":100,"id":603,"idStr":"SSSSVhC1f","interest":7.8,"maturityDuration":"30天","maxAmount":1000,"maxInterest":7.8,"minAmount":1,"minInterest":7.8,"normalInterest":4.8,"productChannelId":2,"productInterestType":"固定收益","productName":"丰田抵押借款 第387期","productStatus":"SALES_OVER","productStatusValue":"售罄","productTypeName":"常规固定期限产品","productTypeValue":"FIXED_TERM_PRODUCT","recommend":false,"remainingAmount":0,"saleAmount":1000,"saleEndTime":"2018-02-04 00:00:00","saleStartTime":"2018-02-01 09:43:22","startBuyTime":"0时0分","totalAmount":100000,"totalBuyNumber":2,"totalCopies":1000},{"activityDescription":"","appshouDesciption":"app","awardInterest":3,"baseAmount":100,"canJoin":true,"canJoinCode":0,"cornerType":"LENDING","descriptionTitle":"车辆抵押","endBuyTime":"24时0分","finishRatio":100,"id":602,"idStr":"WWWWnMo50","interest":7.8,"maturityDuration":"30天","maxAmount":1000,"maxInterest":7.8,"minAmount":1,"minInterest":7.8,"normalInterest":4.8,"passTime":"2018-02-02 11:03:14","productChannelId":2,"productInterestType":"固定收益","productName":"丰田抵押借款 第386期","productStatus":"LENDING","productStatusValue":"还款中","productTypeName":"常规固定期限产品","productTypeValue":"FIXED_TERM_PRODUCT","recommend":false,"remainingAmount":0,"saleAmount":1000,"saleEndTime":"2018-02-03 00:00:00","saleStartTime":"2018-01-31 13:52:10","startBuyTime":"0时0分","startInterestDate":"2018-02-02","totalAmount":100000,"totalBuyNumber":2,"totalCopies":1000}],"listIcon":[{"carId":1,"cityId":1,"id":1,"productId":36},{"carId":3,"cityId":2,"id":2,"productId":38},{"carId":20,"cityId":1,"id":3,"productId":41},{"carId":7,"cityId":1,"id":4,"productId":44},{"carId":8,"cityId":1,"id":5,"productId":45},{"carId":13,"cityId":0,"id":6,"productId":49},{"carId":13,"cityId":1,"id":7,"productId":50},{"carId":2,"cityId":0,"id":8,"productId":50},{"carId":13,"cityId":1,"id":9,"productId":51},{"carId":13,"cityId":1,"id":10,"productId":52},{"carId":2,"cityId":1,"id":11,"productId":53},{"carId":2,"cityId":1,"id":12,"productId":54},{"carId":0,"cityId":0,"id":13,"productId":55},{"carId":0,"cityId":0,"id":14,"productId":56},{"carId":2,"cityId":1,"id":15,"productId":57},{"carId":16,"cityId":1,"id":16,"productId":58},{"carId":16,"cityId":1,"id":17,"productId":59},{"carId":2,"cityId":1,"id":18,"productId":60},{"carId":1,"cityId":1,"id":19,"productId":61},{"carId":1,"cityId":1,"id":20,"productId":62},{"carId":18,"cityId":1,"id":21,"productId":64},{"carId":1,"cityId":1,"id":22,"productId":65},{"carId":21,"cityId":1,"id":23,"productId":66},{"carId":21,"cityId":1,"id":24,"productId":67},{"carId":5,"cityId":1,"id":25,"productId":68},{"carId":1,"cityId":1,"id":26,"productId":70},{"carId":2,"cityId":1,"id":27,"productId":71},{"carId":7,"cityId":1,"id":28,"productId":74},{"carId":5,"cityId":1,"id":29,"productId":77},{"carId":18,"cityId":1,"id":30,"productId":78},{"carId":53,"cityId":1,"id":31,"productId":79},{"carId":5,"cityId":2,"id":32,"productId":80},{"carId":18,"cityId":1,"id":33,"productId":81},{"carId":3,"cityId":1,"id":34,"productId":83},{"carId":1,"cityId":1,"id":35,"productId":87},{"carId":13,"cityId":1,"id":36,"productId":90},{"carId":3,"cityId":1,"id":37,"productId":91},{"carId":16,"cityId":1,"id":38,"productId":94},{"carId":1,"cityId":1,"id":39,"productId":97},{"carId":13,"cityId":1,"id":40,"productId":99},{"carId":3,"cityId":1,"id":41,"productId":100},{"carId":0,"cityId":0,"id":42,"productId":101},{"carId":16,"cityId":1,"id":43,"productId":102},{"carId":16,"cityId":1,"id":44,"productId":104},{"carId":22,"cityId":1,"id":45,"productId":105},{"carId":59,"cityId":1,"id":46,"productId":106},{"carId":0,"cityId":1,"id":47,"productId":107},{"carId":59,"cityId":1,"id":48,"productId":109},{"carId":0,"cityId":1,"id":49,"productId":111},{"carId":59,"cityId":1,"id":50,"productId":112},{"carId":7,"cityId":1,"id":51,"productId":114},{"carId":7,"cityId":1,"id":52,"productId":116},{"carId":7,"cityId":1,"id":53,"productId":117},{"carId":5,"cityId":2,"id":54,"productId":118},{"carId":7,"cityId":1,"id":55,"productId":119},{"carId":1,"cityId":1,"id":56,"productId":120},{"carId":1,"cityId":1,"id":57,"productId":121},{"carId":1,"cityId":1,"id":58,"productId":122},{"carId":53,"cityId":1,"id":59,"productId":123},{"carId":2,"cityId":1,"id":60,"productId":124},{"carId":7,"cityId":1,"id":61,"productId":125},{"carId":16,"cityId":2,"id":62,"productId":126},{"carId":7,"cityId":1,"id":63,"productId":127},{"carId":16,"cityId":2,"id":64,"productId":129},{"carId":1,"cityId":1,"id":65,"productId":131},{"carId":1,"cityId":1,"id":66,"productId":132},{"carId":7,"cityId":1,"id":67,"productId":132},{"carId":60,"cityId":1,"id":71,"productId":137},{"carId":7,"cityId":1,"id":69,"productId":135},{"carId":1,"cityId":1,"id":72,"productId":138},{"carId":7,"cityId":1,"id":73,"productId":139},{"carId":1,"cityId":1,"id":74,"productId":134},{"carId":13,"cityId":1,"id":75,"productId":140},{"carId":60,"cityId":1,"id":76,"productId":141},{"carId":18,"cityId":1,"id":77,"productId":142},{"carId":1,"cityId":1,"id":78,"productId":143},{"carId":1,"cityId":1,"id":79,"productId":144},{"carId":39,"cityId":1,"id":80,"productId":145},{"carId":39,"cityId":1,"id":81,"productId":146},{"carId":39,"cityId":1,"id":82,"productId":147},{"carId":39,"cityId":1,"id":83,"productId":148},{"carId":36,"cityId":1,"id":84,"productId":149},{"carId":16,"cityId":2,"id":85,"productId":150},{"carId":13,"cityId":1,"id":90,"productId":153},{"carId":13,"cityId":1,"id":87,"productId":152},{"carId":16,"cityId":1,"id":88,"productId":154},{"carId":13,"cityId":1,"id":91,"productId":155},{"carId":16,"cityId":1,"id":92,"productId":156},{"carId":2,"cityId":1,"id":93,"productId":158},{"carId":5,"cityId":1,"id":94,"productId":159},{"carId":2,"cityId":1,"id":95,"productId":160},{"carId":10,"cityId":1,"id":96,"productId":161},{"carId":1,"cityId":1,"id":97,"productId":162},{"carId":1,"cityId":1,"id":98,"productId":163},{"carId":1,"cityId":1,"id":99,"productId":164},{"carId":1,"cityId":1,"id":100,"productId":166},{"carId":16,"cityId":1,"id":101,"productId":167},{"carId":10,"cityId":1,"id":102,"productId":169},{"carId":13,"cityId":1,"id":103,"productId":170},{"carId":20,"cityId":1,"id":104,"productId":171},{"carId":20,"cityId":1,"id":105,"productId":172},{"carId":20,"cityId":1,"id":106,"productId":173},{"carId":20,"cityId":1,"id":107,"productId":174},{"carId":20,"cityId":1,"id":108,"productId":175},{"carId":20,"cityId":1,"id":109,"productId":176},{"carId":61,"cityId":1,"id":110,"productId":177},{"carId":61,"cityId":1,"id":111,"productId":178},{"carId":3,"cityId":1,"id":112,"productId":179},{"carId":3,"cityId":1,"id":113,"productId":180},{"carId":1,"cityId":1,"id":114,"productId":181},{"carId":7,"cityId":1,"id":115,"productId":182},{"carId":7,"cityId":1,"id":116,"productId":183},{"carId":7,"cityId":1,"id":117,"productId":185},{"carId":16,"cityId":1,"id":118,"productId":187},{"carId":1,"cityId":1,"id":119,"productId":188},{"carId":13,"cityId":1,"id":120,"productId":189},{"carId":1,"cityId":1,"id":121,"productId":190},{"carId":2,"cityId":1,"id":122,"productId":191},{"carId":62,"cityId":1,"id":123,"productId":192},{"carId":8,"cityId":1,"id":124,"productId":193},{"carId":1,"cityId":1,"id":125,"productId":194},{"carId":3,"cityId":1,"id":126,"productId":195},{"carId":1,"cityId":1,"id":127,"productId":196},{"carId":3,"cityId":1,"id":128,"productId":197},{"carId":1,"cityId":1,"id":129,"productId":198},{"carId":3,"cityId":1,"id":130,"productId":199},{"carId":18,"cityId":1,"id":131,"productId":200},{"carId":1,"cityId":1,"id":132,"productId":201},{"carId":10,"cityId":1,"id":133,"productId":202},{"carId":10,"cityId":1,"id":134,"productId":203},{"carId":1,"cityId":1,"id":135,"productId":204},{"carId":13,"cityId":1,"id":136,"productId":205},{"carId":7,"cityId":1,"id":137,"productId":206},{"carId":3,"cityId":1,"id":138,"productId":207},{"carId":2,"cityId":1,"id":139,"productId":208},{"carId":20,"cityId":1,"id":140,"productId":209},{"carId":2,"cityId":1,"id":141,"productId":210},{"carId":2,"cityId":1,"id":142,"productId":211},{"carId":20,"cityId":1,"id":143,"productId":212},{"carId":2,"cityId":1,"id":144,"productId":213},{"carId":13,"cityId":1,"id":145,"productId":214},{"carId":13,"cityId":1,"id":146,"productId":215},{"carId":11,"cityId":1,"id":147,"productId":216},{"carId":21,"cityId":1,"id":148,"productId":217},{"carId":7,"cityId":1,"id":149,"productId":219},{"carId":10,"cityId":1,"id":150,"productId":220},{"carId":10,"cityId":1,"id":151,"productId":221},{"carId":8,"cityId":1,"id":152,"productId":222},{"carId":10,"cityId":1,"id":153,"productId":223},{"carId":10,"cityId":1,"id":154,"productId":224},{"carId":10,"cityId":1,"id":155,"productId":225},{"carId":10,"cityId":1,"id":156,"productId":226},{"carId":1,"cityId":1,"id":157,"productId":228},{"carId":16,"cityId":1,"id":158,"productId":229},{"carId":1,"cityId":1,"id":159,"productId":230},{"carId":1,"cityId":1,"id":160,"productId":231},{"carId":1,"cityId":1,"id":161,"productId":233},{"carId":1,"cityId":1,"id":162,"productId":234},{"carId":16,"cityId":1,"id":163,"productId":235},{"carId":2,"cityId":1,"id":164,"productId":236},{"carId":10,"cityId":1,"id":165,"productId":237},{"carId":10,"cityId":1,"id":166,"productId":238},{"carId":7,"cityId":1,"id":167,"productId":239},{"carId":1,"cityId":1,"id":168,"productId":240},{"carId":1,"cityId":1,"id":169,"productId":241},{"carId":1,"cityId":1,"id":170,"productId":242},{"carId":1,"cityId":1,"id":171,"productId":243},{"carId":1,"cityId":1,"id":172,"productId":244},{"carId":1,"cityId":1,"id":173,"productId":245},{"carId":10,"cityId":1,"id":174,"productId":246},{"carId":10,"cityId":1,"id":175,"productId":247},{"carId":1,"cityId":1,"id":176,"productId":248},{"carId":24,"cityId":1,"id":177,"productId":249},{"carId":24,"cityId":1,"id":178,"productId":250},{"carId":24,"cityId":1,"id":179,"productId":251},{"carId":8,"cityId":1,"id":180,"productId":252},{"carId":22,"cityId":1,"id":181,"productId":253},{"carId":1,"cityId":1,"id":182,"productId":254},{"carId":1,"cityId":1,"id":183,"productId":255},{"carId":29,"cityId":1,"id":184,"productId":256},{"carId":18,"cityId":1,"id":185,"productId":257},{"carId":1,"cityId":1,"id":186,"productId":258},{"carId":1,"cityId":1,"id":187,"productId":259},{"carId":16,"cityId":1,"id":188,"productId":260},{"carId":16,"cityId":1,"id":189,"productId":261},{"carId":13,"cityId":1,"id":190,"productId":262},{"carId":8,"cityId":1,"id":191,"productId":264},{"carId":1,"cityId":1,"id":192,"productId":265},{"carId":1,"cityId":1,"id":193,"productId":266},{"carId":21,"cityId":1,"id":194,"productId":267},{"carId":22,"cityId":1,"id":195,"productId":268},{"carId":22,"cityId":1,"id":196,"productId":269},{"carId":2,"cityId":1,"id":197,"productId":270},{"carId":18,"cityId":1,"id":198,"productId":271},{"carId":18,"cityId":1,"id":199,"productId":272},{"carId":1,"cityId":1,"id":200,"productId":273},{"carId":2,"cityId":1,"id":201,"productId":274},{"carId":1,"cityId":1,"id":202,"productId":275},{"carId":0,"cityId":1,"id":203,"productId":276},{"carId":18,"cityId":1,"id":204,"productId":277},{"carId":1,"cityId":1,"id":205,"productId":278},{"carId":1,"cityId":1,"id":206,"productId":280},{"carId":1,"cityId":1,"id":207,"productId":281},{"carId":1,"cityId":1,"id":208,"productId":282},{"carId":10,"cityId":1,"id":209,"productId":283},{"carId":1,"cityId":1,"id":210,"productId":284},{"carId":1,"cityId":1,"id":211,"productId":285},{"carId":18,"cityId":1,"id":212,"productId":286},{"carId":8,"cityId":1,"id":213,"productId":287},{"carId":16,"cityId":1,"id":214,"productId":288},{"carId":7,"cityId":1,"id":215,"productId":289},{"carId":18,"cityId":1,"id":216,"productId":290},{"carId":13,"cityId":1,"id":217,"productId":291},{"carId":16,"cityId":1,"id":218,"productId":292},{"carId":7,"cityId":1,"id":219,"productId":293},{"carId":7,"cityId":1,"id":220,"productId":294},{"carId":18,"cityId":1,"id":221,"productId":295},{"carId":1,"cityId":1,"id":222,"productId":296},{"carId":2,"cityId":1,"id":223,"productId":297},{"carId":7,"cityId":1,"id":224,"productId":298},{"carId":1,"cityId":1,"id":225,"productId":299},{"carId":7,"cityId":1,"id":226,"productId":302},{"carId":1,"cityId":1,"id":227,"productId":303},{"carId":1,"cityId":1,"id":228,"productId":304},{"carId":1,"cityId":1,"id":229,"productId":305},{"carId":22,"cityId":1,"id":230,"productId":306},{"carId":3,"cityId":1,"id":231,"productId":307},{"carId":55,"cityId":1,"id":232,"productId":308},{"carId":55,"cityId":1,"id":233,"productId":309},{"carId":20,"cityId":1,"id":234,"productId":310},{"carId":1,"cityId":1,"id":235,"productId":311},{"carId":56,"cityId":1,"id":236,"productId":312},{"carId":53,"cityId":1,"id":237,"productId":313},{"carId":1,"cityId":1,"id":238,"productId":314},{"carId":2,"cityId":1,"id":239,"productId":315},{"carId":18,"cityId":1,"id":240,"productId":317},{"carId":1,"cityId":1,"id":241,"productId":318},{"carId":1,"cityId":1,"id":242,"productId":319},{"carId":1,"cityId":2,"id":243,"productId":320},{"carId":1,"cityId":1,"id":244,"productId":321},{"carId":1,"cityId":1,"id":245,"productId":322},{"carId":18,"cityId":1,"id":246,"productId":323},{"carId":1,"cityId":1,"id":247,"productId":324},{"carId":22,"cityId":1,"id":248,"productId":325},{"carId":24,"cityId":1,"id":249,"productId":326},{"carId":1,"cityId":1,"id":250,"productId":327},{"carId":5,"cityId":1,"id":251,"productId":328},{"carId":5,"cityId":1,"id":252,"productId":329},{"carId":1,"cityId":1,"id":253,"productId":330},{"carId":20,"cityId":1,"id":254,"productId":331},{"carId":1,"cityId":1,"id":255,"productId":332},{"carId":53,"cityId":1,"id":256,"productId":333},{"carId":1,"cityId":1,"id":257,"productId":334},{"carId":1,"cityId":1,"id":258,"productId":335},{"carId":1,"cityId":1,"id":259,"productId":336},{"carId":8,"cityId":1,"id":260,"productId":337},{"carId":1,"cityId":1,"id":261,"productId":338},{"carId":1,"cityId":1,"id":262,"productId":339},{"carId":61,"cityId":1,"id":263,"productId":340},{"carId":1,"cityId":1,"id":264,"productId":341},{"carId":1,"cityId":1,"id":265,"productId":342},{"carId":8,"cityId":1,"id":266,"productId":343},{"carId":63,"cityId":1,"id":267,"productId":346},{"carId":18,"cityId":1,"id":268,"productId":347},{"carId":13,"cityId":1,"id":269,"productId":348},{"carId":1,"cityId":1,"id":270,"productId":349},{"carId":7,"cityId":1,"id":271,"productId":350},{"carId":10,"cityId":1,"id":272,"productId":351},{"carId":1,"cityId":1,"id":273,"productId":352},{"carId":16,"cityId":1,"id":274,"productId":353},{"carId":2,"cityId":1,"id":275,"productId":355},{"carId":8,"cityId":1,"id":276,"productId":356},{"carId":10,"cityId":1,"id":277,"productId":357},{"carId":1,"cityId":1,"id":278,"productId":358},{"carId":24,"cityId":1,"id":279,"productId":360},{"carId":1,"cityId":2,"id":280,"productId":361},{"carId":1,"cityId":1,"id":281,"productId":362},{"carId":0,"cityId":0,"id":282,"productId":363},{"carId":7,"cityId":1,"id":283,"productId":364},{"carId":21,"cityId":1,"id":284,"productId":365},{"carId":18,"cityId":1,"id":285,"productId":366},{"carId":20,"cityId":1,"id":286,"productId":368},{"carId":20,"cityId":1,"id":287,"productId":369},{"carId":20,"cityId":1,"id":288,"productId":370},{"carId":20,"cityId":1,"id":289,"productId":371},{"carId":61,"cityId":1,"id":290,"productId":372},{"carId":61,"cityId":1,"id":291,"productId":373},{"carId":25,"cityId":2,"id":292,"productId":374},{"carId":13,"cityId":1,"id":293,"productId":375},{"carId":10,"cityId":1,"id":294,"productId":376},{"carId":18,"cityId":1,"id":295,"productId":378},{"carId":7,"cityId":1,"id":296,"productId":379},{"carId":53,"cityId":1,"id":297,"productId":380},{"carId":3,"cityId":1,"id":298,"productId":381},{"carId":1,"cityId":1,"id":299,"productId":382},{"carId":18,"cityId":1,"id":300,"productId":384},{"carId":8,"cityId":1,"id":301,"productId":385},{"carId":1,"cityId":1,"id":302,"productId":386},{"carId":13,"cityId":2,"id":303,"productId":387},{"carId":18,"cityId":1,"id":304,"productId":388},{"carId":10,"cityId":1,"id":305,"productId":389},{"carId":0,"cityId":1,"id":306,"productId":390},{"carId":8,"cityId":1,"id":307,"productId":391},{"carId":7,"cityId":1,"id":308,"productId":392},{"carId":21,"cityId":1,"id":309,"productId":393},{"carId":1,"cityId":1,"id":310,"productId":394},{"carId":1,"cityId":1,"id":311,"productId":395},{"carId":11,"cityId":1,"id":312,"productId":396},{"carId":10,"cityId":1,"id":313,"productId":397},{"carId":18,"cityId":1,"id":314,"productId":398},{"carId":18,"cityId":1,"id":315,"productId":399},{"carId":15,"cityId":1,"id":316,"productId":400},{"carId":1,"cityId":1,"id":317,"productId":401},{"carId":29,"cityId":1,"id":318,"productId":402},{"carId":10,"cityId":1,"id":319,"productId":403},{"carId":64,"cityId":2,"id":320,"productId":404},{"carId":7,"cityId":1,"id":321,"productId":405},{"carId":16,"cityId":1,"id":322,"productId":406},{"carId":7,"cityId":1,"id":323,"productId":407},{"carId":1,"cityId":1,"id":324,"productId":408},{"carId":1,"cityId":2,"id":325,"productId":409},{"carId":3,"cityId":1,"id":326,"productId":410},{"carId":16,"cityId":1,"id":327,"productId":411},{"carId":8,"cityId":1,"id":328,"productId":412},{"carId":11,"cityId":1,"id":329,"productId":413},{"carId":1,"cityId":1,"id":330,"productId":414},{"carId":7,"cityId":1,"id":331,"productId":415},{"carId":1,"cityId":1,"id":332,"productId":416},{"carId":20,"cityId":1,"id":333,"productId":417},{"carId":16,"cityId":1,"id":334,"productId":418},{"carId":16,"cityId":1,"id":335,"productId":419},{"carId":16,"cityId":1,"id":336,"productId":420},{"carId":16,"cityId":1,"id":337,"productId":421},{"carId":13,"cityId":1,"id":338,"productId":422},{"carId":13,"cityId":1,"id":339,"productId":423},{"carId":1,"cityId":1,"id":340,"productId":424},{"carId":1,"cityId":1,"id":341,"productId":425},{"carId":7,"cityId":1,"id":342,"productId":426},{"carId":1,"cityId":1,"id":343,"productId":427},{"carId":3,"cityId":1,"id":344,"productId":428},{"carId":1,"cityId":1,"id":345,"productId":429},{"carId":15,"cityId":1,"id":346,"productId":430},{"carId":1,"cityId":1,"id":347,"productId":431},{"carId":7,"cityId":1,"id":348,"productId":432},{"carId":7,"cityId":1,"id":349,"productId":433},{"carId":1,"cityId":1,"id":350,"productId":434},{"carId":13,"cityId":1,"id":351,"productId":435},{"carId":13,"cityId":1,"id":352,"productId":436},{"carId":1,"cityId":1,"id":353,"productId":437},{"carId":1,"cityId":1,"id":354,"productId":439},{"carId":8,"cityId":1,"id":355,"productId":440},{"carId":1,"cityId":1,"id":356,"productId":441},{"carId":7,"cityId":1,"id":357,"productId":442},{"carId":53,"cityId":1,"id":358,"productId":443},{"carId":3,"cityId":1,"id":359,"productId":444},{"carId":13,"cityId":1,"id":360,"productId":445},{"carId":8,"cityId":1,"id":361,"productId":446},{"carId":3,"cityId":1,"id":362,"productId":447},{"carId":10,"cityId":1,"id":363,"productId":448},{"carId":11,"cityId":1,"id":364,"productId":449},{"carId":13,"cityId":1,"id":365,"productId":450},{"carId":1,"cityId":1,"id":366,"productId":451},{"carId":3,"cityId":1,"id":367,"productId":452},{"carId":3,"cityId":1,"id":368,"productId":453},{"carId":49,"cityId":1,"id":369,"productId":454},{"carId":13,"cityId":1,"id":370,"productId":455},{"carId":49,"cityId":1,"id":371,"productId":457},{"carId":49,"cityId":1,"id":372,"productId":458},{"carId":13,"cityId":1,"id":373,"productId":459},{"carId":13,"cityId":1,"id":374,"productId":460},{"carId":3,"cityId":1,"id":375,"productId":461},{"carId":8,"cityId":1,"id":376,"productId":462},{"carId":1,"cityId":1,"id":377,"productId":463},{"carId":16,"cityId":1,"id":378,"productId":464},{"carId":1,"cityId":1,"id":379,"productId":465},{"carId":1,"cityId":1,"id":380,"productId":466},{"carId":8,"cityId":1,"id":381,"productId":467},{"carId":20,"cityId":1,"id":382,"productId":468},{"carId":16,"cityId":1,"id":383,"productId":469},{"carId":7,"cityId":1,"id":384,"productId":470},{"carId":1,"cityId":1,"id":385,"productId":471},{"carId":1,"cityId":1,"id":386,"productId":472},{"carId":8,"cityId":1,"id":387,"productId":473},{"carId":53,"cityId":1,"id":388,"productId":474},{"carId":11,"cityId":1,"id":389,"productId":475},{"carId":8,"cityId":1,"id":390,"productId":476},{"carId":3,"cityId":1,"id":391,"productId":477},{"carId":8,"cityId":1,"id":392,"productId":478},{"carId":10,"cityId":1,"id":393,"productId":479},{"carId":11,"cityId":1,"id":394,"productId":480},{"carId":5,"cityId":1,"id":395,"productId":481},{"carId":7,"cityId":1,"id":396,"productId":482},{"carId":8,"cityId":1,"id":397,"productId":483},{"carId":3,"cityId":1,"id":398,"productId":484},{"carId":3,"cityId":1,"id":399,"productId":485},{"carId":16,"cityId":1,"id":400,"productId":486},{"carId":3,"cityId":1,"id":401,"productId":487},{"carId":8,"cityId":1,"id":402,"productId":488},{"carId":10,"cityId":1,"id":403,"productId":489},{"carId":3,"cityId":2,"id":404,"productId":490},{"carId":11,"cityId":1,"id":405,"productId":491},{"carId":1,"cityId":1,"id":406,"productId":492},{"carId":13,"cityId":1,"id":407,"productId":493},{"carId":8,"cityId":1,"id":408,"productId":494},{"carId":5,"cityId":1,"id":409,"productId":495},{"carId":10,"cityId":1,"id":410,"productId":496},{"carId":1,"cityId":1,"id":411,"productId":497},{"carId":16,"cityId":1,"id":412,"productId":498},{"carId":1,"cityId":1,"id":413,"productId":499},{"carId":1,"cityId":1,"id":414,"productId":500},{"carId":8,"cityId":1,"id":415,"productId":501},{"carId":1,"cityId":1,"id":416,"productId":502},{"carId":15,"cityId":1,"id":417,"productId":503},{"carId":5,"cityId":1,"id":418,"productId":504},{"carId":3,"cityId":1,"id":419,"productId":505},{"carId":3,"cityId":1,"id":420,"productId":506},{"carId":16,"cityId":1,"id":421,"productId":507},{"carId":15,"cityId":1,"id":422,"productId":508},{"carId":1,"cityId":1,"id":423,"productId":510},{"carId":17,"cityId":2,"id":424,"productId":511},{"carId":7,"cityId":1,"id":425,"productId":512},{"carId":1,"cityId":1,"id":426,"productId":513},{"carId":20,"cityId":1,"id":427,"productId":514},{"carId":65,"cityId":1,"id":428,"productId":515},{"carId":16,"cityId":1,"id":429,"productId":516},{"carId":1,"cityId":1,"id":430,"productId":517},{"carId":7,"cityId":1,"id":431,"productId":518},{"carId":7,"cityId":1,"id":432,"productId":519},{"carId":16,"cityId":1,"id":433,"productId":520},{"carId":29,"cityId":1,"id":434,"productId":521},{"carId":20,"cityId":1,"id":435,"productId":522},{"carId":63,"cityId":1,"id":436,"productId":525},{"carId":1,"cityId":1,"id":437,"productId":526},{"carId":13,"cityId":1,"id":438,"productId":527},{"carId":1,"cityId":1,"id":439,"productId":528},{"carId":1,"cityId":1,"id":440,"productId":529},{"carId":7,"cityId":1,"id":441,"productId":530},{"carId":1,"cityId":1,"id":442,"productId":531},{"carId":3,"cityId":1,"id":443,"productId":532},{"carId":1,"cityId":1,"id":444,"productId":533},{"carId":1,"cityId":1,"id":445,"productId":534},{"carId":2,"cityId":1,"id":446,"productId":535},{"carId":18,"cityId":1,"id":447,"productId":536},{"carId":1,"cityId":1,"id":448,"productId":537},{"carId":13,"cityId":1,"id":449,"productId":538},{"carId":10,"cityId":1,"id":450,"productId":539},{"carId":50,"cityId":1,"id":451,"productId":542},{"carId":50,"cityId":1,"id":452,"productId":543},{"carId":16,"cityId":1,"id":453,"productId":544},{"carId":3,"cityId":1,"id":454,"productId":545},{"carId":1,"cityId":1,"id":455,"productId":546},{"carId":1,"cityId":1,"id":456,"productId":547},{"carId":3,"cityId":1,"id":457,"productId":548},{"carId":1,"cityId":1,"id":458,"productId":549},{"carId":8,"cityId":1,"id":459,"productId":550},{"carId":1,"cityId":2,"id":460,"productId":551},{"carId":10,"cityId":1,"id":461,"productId":552},{"carId":1,"cityId":1,"id":462,"productId":553},{"carId":16,"cityId":1,"id":463,"productId":554},{"carId":16,"cityId":1,"id":464,"productId":555},{"carId":2,"cityId":1,"id":465,"productId":556},{"carId":60,"cityId":1,"id":466,"productId":557},{"carId":3,"cityId":1,"id":467,"productId":558},{"carId":1,"cityId":1,"id":468,"productId":559},{"carId":18,"cityId":1,"id":469,"productId":560},{"carId":7,"cityId":1,"id":470,"productId":561},{"carId":7,"cityId":1,"id":471,"productId":562},{"carId":16,"cityId":1,"id":472,"productId":563},{"carId":8,"cityId":1,"id":473,"productId":564},{"carId":29,"cityId":1,"id":474,"productId":565},{"carId":10,"cityId":1,"id":475,"productId":566},{"carId":54,"cityId":1,"id":476,"productId":567},{"carId":49,"cityId":1,"id":477,"productId":568},{"carId":1,"cityId":1,"id":478,"productId":569},{"carId":1,"cityId":1,"id":479,"productId":570},{"carId":16,"cityId":1,"id":480,"productId":571},{"carId":7,"cityId":1,"id":481,"productId":572},{"carId":49,"cityId":1,"id":482,"productId":573},{"carId":10,"cityId":1,"id":483,"productId":574},{"carId":8,"cityId":1,"id":484,"productId":575},{"carId":3,"cityId":1,"id":485,"productId":576},{"carId":10,"cityId":1,"id":486,"productId":577},{"carId":49,"cityId":1,"id":487,"productId":578},{"carId":53,"cityId":1,"id":488,"productId":579},{"carId":1,"cityId":1,"id":489,"productId":580},{"carId":22,"cityId":1,"id":490,"productId":581},{"carId":67,"cityId":2,"id":491,"productId":582},{"carId":67,"cityId":2,"id":492,"productId":583},{"carId":1,"cityId":1,"id":493,"productId":584},{"carId":1,"cityId":1,"id":494,"productId":585},{"carId":13,"cityId":1,"id":495,"productId":586},{"carId":11,"cityId":1,"id":496,"productId":587},{"carId":49,"cityId":1,"id":497,"productId":588},{"carId":3,"cityId":1,"id":498,"productId":589},{"carId":2,"cityId":1,"id":499,"productId":590},{"carId":2,"cityId":1,"id":500,"productId":591},{"carId":13,"cityId":1,"id":501,"productId":592},{"carId":13,"cityId":1,"id":502,"productId":593},{"carId":16,"cityId":1,"id":503,"productId":594},{"carId":11,"cityId":1,"id":504,"productId":595},{"carId":11,"cityId":1,"id":505,"productId":596},{"carId":5,"cityId":1,"id":506,"productId":597},{"carId":5,"cityId":1,"id":507,"productId":598},{"carId":3,"cityId":1,"id":508,"productId":599},{"carId":1,"cityId":1,"id":509,"productId":600},{"carId":13,"cityId":1,"id":510,"productId":601},{"carId":1,"cityId":1,"id":511,"productId":602},{"carId":1,"cityId":1,"id":512,"productId":603},{"carId":16,"cityId":1,"id":513,"productId":604},{"carId":29,"cityId":1,"id":514,"productId":605},{"carId":16,"cityId":1,"id":515,"productId":606},{"carId":1,"cityId":1,"id":516,"productId":607},{"carId":8,"cityId":1,"id":517,"productId":608},{"carId":1,"cityId":1,"id":518,"productId":609},{"carId":3,"cityId":1,"id":519,"productId":610},{"carId":7,"cityId":1,"id":520,"productId":611}],"total":301}
	 * message : 查询成功
	 * success : true
	 */

	private int code;
	private DataBean data;
	private String message;
	private boolean success;

	public static LoanPageAdapter objectFromData(String str) {

		return new Gson().fromJson(str, LoanPageAdapter.class);
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public DataBean getData() {
		return data;
	}

	public void setData(DataBean data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public static class DataBean {
		/**
		 * list : [{"activityDescription":"","appshouDesciption":"app","baseAmount":100,"canJoin":true,"canJoinCode":0,"cornerType":"TASTE","descriptionTitle":"车辆抵押","endBuyTime":"24时0分","finishRatio":70,"id":605,"idStr":"eeeegqq9k","interest":14,"maturityDuration":"10天","maxAmount":100,"maxInterest":14,"minAmount":1,"minInterest":14,"normalInterest":14,"productChannelId":2,"productInterestType":"固定收益","productName":"比亚迪抵押借款 第389期","productStatus":"SALES","productStatusValue":"销售中","productTypeName":"短期体验产品","productTypeValue":"SHORT_TASTE_PRODUCT","recommend":false,"remainingAmount":30,"saleAmount":70,"saleEndTime":"2018-02-07 00:00:00","saleStartTime":"2018-02-04 13:27:36","startBuyTime":"0时0分","totalAmount":10000,"totalBuyNumber":7,"totalCopies":100},{"activityDescription":"","appshouDesciption":"app","awardInterest":3,"baseAmount":100,"canJoin":true,"canJoinCode":0,"cornerType":"ACTIVITY","descriptionTitle":"车辆抵押","endBuyTime":"24时0分","finishRatio":0,"id":609,"idStr":"WWWWRWZ2f","interest":12.8,"maturityDuration":"180天","maxAmount":650,"maxInterest":12.8,"minAmount":1,"minInterest":12.8,"normalInterest":9.8,"productChannelId":2,"productInterestType":"固定收益","productName":"丰田抵押借款 第393期","productStatus":"SALES","productStatusValue":"销售中","productTypeName":"常规固定期限产品","productTypeValue":"FIXED_TERM_PRODUCT","recommend":false,"remainingAmount":650,"saleAmount":0,"saleEndTime":"2018-02-08 00:00:00","saleStartTime":"2018-02-05 11:13:39","startBuyTime":"0时0分","totalAmount":65000,"totalBuyNumber":0,"totalCopies":650},{"activityDescription":"","appshouDesciption":"app","awardInterest":3,"baseAmount":100,"canJoin":true,"canJoinCode":0,"cornerType":"ACTIVITY","descriptionTitle":"车辆抵押","endBuyTime":"24时0分","finishRatio":0,"id":608,"idStr":"SSSSXST44","interest":10.8,"maturityDuration":"90天","maxAmount":600,"maxInterest":10.8,"minAmount":1,"minInterest":10.8,"normalInterest":7.800000000000001,"productChannelId":2,"productInterestType":"固定收益","productName":"东风日产抵押借款 第392期","productStatus":"SALES","productStatusValue":"销售中","productTypeName":"常规固定期限产品","productTypeValue":"FIXED_TERM_PRODUCT","recommend":false,"remainingAmount":600,"saleAmount":0,"saleEndTime":"2018-02-08 00:00:00","saleStartTime":"2018-02-05 11:05:54","startBuyTime":"0时0分","totalAmount":60000,"totalBuyNumber":0,"totalCopies":600},{"activityDescription":"","appshouDesciption":"app","awardInterest":3,"baseAmount":100,"canJoin":true,"canJoinCode":0,"cornerType":"ACTIVITY","descriptionTitle":"车辆抵押","endBuyTime":"24时0分","finishRatio":0,"id":607,"idStr":"BBBBtBDfb","interest":9.8,"maturityDuration":"60天","maxAmount":900,"maxInterest":9.8,"minAmount":1,"minInterest":9.8,"normalInterest":6.800000000000001,"productChannelId":2,"productInterestType":"固定收益","productName":"丰田抵押借款 第391期","productStatus":"SALES","productStatusValue":"销售中","productTypeName":"常规固定期限产品","productTypeValue":"FIXED_TERM_PRODUCT","recommend":false,"remainingAmount":900,"saleAmount":0,"saleEndTime":"2018-02-08 00:00:00","saleStartTime":"2018-02-05 10:57:25","startBuyTime":"0时0分","totalAmount":90000,"totalBuyNumber":0,"totalCopies":900},{"activityDescription":"","appshouDesciption":"app","awardInterest":3,"baseAmount":100,"canJoin":true,"canJoinCode":0,"cornerType":"ACTIVITY","descriptionTitle":"车辆抵押","endBuyTime":"24时0分","finishRatio":61.54,"id":611,"idStr":"BBBBRBA1f","interest":7.8,"maturityDuration":"30天","maxAmount":1300,"maxInterest":7.8,"minAmount":1,"minInterest":7.8,"normalInterest":4.8,"productChannelId":2,"productInterestType":"固定收益","productName":"奥迪抵押借款 第395期","productStatus":"SALES","productStatusValue":"销售中","productTypeName":"常规固定期限产品","productTypeValue":"FIXED_TERM_PRODUCT","recommend":false,"remainingAmount":500,"saleAmount":800,"saleEndTime":"2018-02-08 00:00:00","saleStartTime":"2018-02-05 14:16:44","startBuyTime":"0时0分","totalAmount":130000,"totalBuyNumber":1,"totalCopies":1300},{"activityDescription":"","appshouDesciption":"app","awardInterest":5.5,"baseAmount":100,"canJoin":true,"canJoinCode":0,"cornerType":"CLOSED","descriptionTitle":"车辆抵押","endBuyTime":"24时0分","finishRatio":100,"id":44,"idStr":"bbbbbZl35","interest":18.8,"maturityDuration":"3天","maxAmount":10,"maxInterest":18.8,"minAmount":1,"minInterest":18.8,"normalInterest":13.3,"passTime":"2017-07-07 18:32:49","productChannelId":2,"productInterestType":"固定收益","productName":"奥迪抵押借款","productStatus":"ENDED","productStatusValue":"已结束","productTypeName":"常规固定期限产品","productTypeValue":"FIXED_TERM_PRODUCT","recommend":false,"remainingAmount":0,"saleAmount":300,"saleEndTime":"2017-07-07 00:00:00","saleStartTime":"2017-07-04 14:43:36","startBuyTime":"0时0分","startInterestDate":"2017-07-07","totalAmount":30000,"totalBuyNumber":13,"totalCopies":300},{"activityDescription":"","appshouDesciption":"app","baseAmount":100,"canJoin":true,"canJoinCode":0,"cornerType":"CLOSED","descriptionTitle":"车辆抵押","endBuyTime":"24时0分","finishRatio":100,"id":270,"idStr":"eeeeatx49","interest":16,"maturityDuration":"3天","maxAmount":50,"maxInterest":16,"minAmount":1,"minInterest":16,"normalInterest":16,"passTime":"2017-09-26 09:14:29","productChannelId":2,"productInterestType":"固定收益","productName":"现代伊兰特抵押借款 第115期","productStatus":"ENDED","productStatusValue":"已结束","productTypeName":"短期体验产品","productTypeValue":"SHORT_TASTE_PRODUCT","recommend":false,"remainingAmount":0,"saleAmount":300,"saleEndTime":"2017-09-23 00:00:00","saleStartTime":"2017-09-20 15:49:10","startBuyTime":"0时0分","startInterestDate":"2017-09-26","totalAmount":30000,"totalBuyNumber":2,"totalCopies":300},{"activityDescription":"","appshouDesciption":"app","baseAmount":100,"canJoin":true,"canJoinCode":0,"cornerType":"CLOSED","descriptionTitle":"车辆抵押","endBuyTime":"24时0分","finishRatio":100,"id":264,"idStr":"WWWWvgk30","interest":16,"maturityDuration":"3天","maxAmount":50,"maxInterest":16,"minAmount":1,"minInterest":16,"normalInterest":16,"passTime":"2017-09-21 09:05:46","productChannelId":2,"productInterestType":"固定收益","productName":"日产轩逸抵押借款 第110期","productStatus":"ENDED","productStatusValue":"已结束","productTypeName":"短期体验产品","productTypeValue":"SHORT_TASTE_PRODUCT","recommend":false,"remainingAmount":0,"saleAmount":300,"saleEndTime":"2017-09-21 00:00:00","saleStartTime":"2017-09-18 16:34:04","startBuyTime":"0时0分","startInterestDate":"2017-09-21","totalAmount":30000,"totalBuyNumber":3,"totalCopies":300},{"activityDescription":"","appshouDesciption":"app","baseAmount":100,"canJoin":true,"canJoinCode":0,"cornerType":"CLOSED","descriptionTitle":"车辆抵押","endBuyTime":"24时0分","finishRatio":100,"id":242,"idStr":"WWWWvctd6","interest":16,"maturityDuration":"3天","maxAmount":50,"maxInterest":16,"minAmount":1,"minInterest":16,"normalInterest":16,"passTime":"2017-09-14 09:04:24","productChannelId":2,"productInterestType":"固定收益","productName":"丰田凯美瑞抵押借款 第95期","productStatus":"ENDED","productStatusValue":"已结束","productTypeName":"短期体验产品","productTypeValue":"SHORT_TASTE_PRODUCT","recommend":false,"remainingAmount":0,"saleAmount":500,"saleEndTime":"2017-09-11 00:00:00","saleStartTime":"2017-09-08 16:07:22","startBuyTime":"0时0分","startInterestDate":"2017-09-14","totalAmount":50000,"totalBuyNumber":2,"totalCopies":500},{"activityDescription":"","appshouDesciption":"app","baseAmount":100,"canJoin":true,"canJoinCode":0,"cornerType":"CLOSED","descriptionTitle":"车辆抵押","endBuyTime":"24时0分","finishRatio":100,"id":226,"idStr":"bbbbTTbb5","interest":16,"maturityDuration":"3天","maxAmount":50,"maxInterest":16,"minAmount":1,"minInterest":16,"normalInterest":16,"passTime":"2017-09-09 08:12:34","productChannelId":2,"productInterestType":"固定收益","productName":"大众捷达抵押借款 第87期","productStatus":"ENDED","productStatusValue":"已结束","productTypeName":"短期体验产品","productTypeValue":"SHORT_TASTE_PRODUCT","recommend":false,"remainingAmount":0,"saleAmount":300,"saleEndTime":"2017-09-08 00:00:00","saleStartTime":"2017-09-05 17:14:57","startBuyTime":"0时0分","startInterestDate":"2017-09-09","totalAmount":30000,"totalBuyNumber":2,"totalCopies":300}]
		 * list1 : [{"activityDescription":"","appshouDesciption":"app","awardInterest":3,"baseAmount":100,"canJoin":true,"canJoinCode":0,"cornerType":"ACTIVITY","descriptionTitle":"车辆抵押","endBuyTime":"24时0分","finishRatio":61.54,"id":611,"idStr":"SSSSoSg1f","interest":7.8,"maturityDuration":"30天","maxAmount":1300,"maxInterest":7.8,"minAmount":1,"minInterest":7.8,"normalInterest":4.8,"productChannelId":2,"productInterestType":"固定收益","productName":"奥迪抵押借款 第395期","productStatus":"SALES","productStatusValue":"销售中","productTypeName":"常规固定期限产品","productTypeValue":"FIXED_TERM_PRODUCT","recommend":false,"remainingAmount":500,"saleAmount":800,"saleEndTime":"2018-02-08 00:00:00","saleStartTime":"2018-02-05 14:16:44","startBuyTime":"0时0分","totalAmount":130000,"totalBuyNumber":1,"totalCopies":1300},{"activityDescription":"","appshouDesciption":"app","awardInterest":3,"baseAmount":100,"canJoin":true,"canJoinCode":0,"cornerType":"ACTIVITY","descriptionTitle":"车辆抵押","endBuyTime":"24时0分","finishRatio":0,"id":609,"idStr":"SSSSoSc2f","interest":12.8,"maturityDuration":"180天","maxAmount":650,"maxInterest":12.8,"minAmount":1,"minInterest":12.8,"normalInterest":9.8,"productChannelId":2,"productInterestType":"固定收益","productName":"丰田抵押借款 第393期","productStatus":"SALES","productStatusValue":"销售中","productTypeName":"常规固定期限产品","productTypeValue":"FIXED_TERM_PRODUCT","recommend":false,"remainingAmount":650,"saleAmount":0,"saleEndTime":"2018-02-08 00:00:00","saleStartTime":"2018-02-05 11:13:39","startBuyTime":"0时0分","totalAmount":65000,"totalBuyNumber":0,"totalCopies":650},{"activityDescription":"","appshouDesciption":"app","awardInterest":3,"baseAmount":100,"canJoin":true,"canJoinCode":0,"cornerType":"ACTIVITY","descriptionTitle":"车辆抵押","endBuyTime":"24时0分","finishRatio":0,"id":608,"idStr":"BBBBzBv44","interest":10.8,"maturityDuration":"90天","maxAmount":600,"maxInterest":10.8,"minAmount":1,"minInterest":10.8,"normalInterest":7.800000000000001,"productChannelId":2,"productInterestType":"固定收益","productName":"东风日产抵押借款 第392期","productStatus":"SALES","productStatusValue":"销售中","productTypeName":"常规固定期限产品","productTypeValue":"FIXED_TERM_PRODUCT","recommend":false,"remainingAmount":600,"saleAmount":0,"saleEndTime":"2018-02-08 00:00:00","saleStartTime":"2018-02-05 11:05:54","startBuyTime":"0时0分","totalAmount":60000,"totalBuyNumber":0,"totalCopies":600},{"activityDescription":"","appshouDesciption":"app","awardInterest":3,"baseAmount":100,"canJoin":true,"canJoinCode":0,"cornerType":"ACTIVITY","descriptionTitle":"车辆抵押","endBuyTime":"24时0分","finishRatio":0,"id":607,"idStr":"WWWWoWYfb","interest":9.8,"maturityDuration":"60天","maxAmount":900,"maxInterest":9.8,"minAmount":1,"minInterest":9.8,"normalInterest":6.800000000000001,"productChannelId":2,"productInterestType":"固定收益","productName":"丰田抵押借款 第391期","productStatus":"SALES","productStatusValue":"销售中","productTypeName":"常规固定期限产品","productTypeValue":"FIXED_TERM_PRODUCT","recommend":false,"remainingAmount":900,"saleAmount":0,"saleEndTime":"2018-02-08 00:00:00","saleStartTime":"2018-02-05 10:57:25","startBuyTime":"0时0分","totalAmount":90000,"totalBuyNumber":0,"totalCopies":900},{"activityDescription":"","appshouDesciption":"app","baseAmount":100,"canJoin":true,"canJoinCode":0,"cornerType":"TASTE","descriptionTitle":"车辆抵押","endBuyTime":"24时0分","finishRatio":70,"id":605,"idStr":"SSSSjqq9k","interest":14,"maturityDuration":"10天","maxAmount":100,"maxInterest":14,"minAmount":1,"minInterest":14,"normalInterest":14,"productChannelId":2,"productInterestType":"固定收益","productName":"比亚迪抵押借款 第389期","productStatus":"SALES","productStatusValue":"销售中","productTypeName":"短期体验产品","productTypeValue":"SHORT_TASTE_PRODUCT","recommend":false,"remainingAmount":30,"saleAmount":70,"saleEndTime":"2018-02-07 00:00:00","saleStartTime":"2018-02-04 13:27:36","startBuyTime":"0时0分","totalAmount":10000,"totalBuyNumber":7,"totalCopies":100},{"activityDescription":"","appshouDesciption":"app","awardInterest":3,"baseAmount":100,"canJoin":true,"canJoinCode":0,"cornerType":"SALE_OVER","descriptionTitle":"车辆抵押","endBuyTime":"24时0分","finishRatio":100,"id":610,"idStr":"WWWWoWQ74","interest":7.8,"maturityDuration":"30天","maxAmount":2000,"maxInterest":7.8,"minAmount":1,"minInterest":7.8,"normalInterest":4.8,"productChannelId":2,"productInterestType":"固定收益","productName":"奔驰抵押借款 第394期","productStatus":"SALES_OVER","productStatusValue":"售罄","productTypeName":"常规固定期限产品","productTypeValue":"FIXED_TERM_PRODUCT","recommend":false,"remainingAmount":0,"saleAmount":2000,"saleEndTime":"2018-02-08 00:00:00","saleStartTime":"2018-02-05 11:44:15","startBuyTime":"0时0分","totalAmount":200000,"totalBuyNumber":5,"totalCopies":2000},{"activityDescription":"","appshouDesciption":"app","awardInterest":3,"baseAmount":100,"canJoin":true,"canJoinCode":0,"cornerType":"SALE_OVER","descriptionTitle":"车辆抵押","endBuyTime":"24时0分","finishRatio":100,"id":606,"idStr":"bbbbobbdk","interest":7.8,"maturityDuration":"30天","maxAmount":2000,"maxInterest":7.8,"minAmount":1,"minInterest":7.8,"normalInterest":4.8,"productChannelId":2,"productInterestType":"固定收益","productName":"宝马抵押借款 第390期","productStatus":"SALES_OVER","productStatusValue":"售罄","productTypeName":"常规固定期限产品","productTypeValue":"FIXED_TERM_PRODUCT","recommend":false,"remainingAmount":0,"saleAmount":2000,"saleEndTime":"2018-02-08 00:00:00","saleStartTime":"2018-02-05 09:44:39","startBuyTime":"0时0分","totalAmount":200000,"totalBuyNumber":4,"totalCopies":2000},{"activityDescription":"","appshouDesciption":"app","awardInterest":3,"baseAmount":100,"canJoin":true,"canJoinCode":0,"cornerType":"SALE_OVER","descriptionTitle":"车辆抵押","endBuyTime":"24时0分","finishRatio":100,"id":604,"idStr":"WWWWVMlk0","interest":7.8,"maturityDuration":"30天","maxAmount":2000,"maxInterest":7.8,"minAmount":1,"minInterest":7.8,"normalInterest":4.8,"productChannelId":2,"productInterestType":"固定收益","productName":"宝马抵押借款 第388期","productStatus":"SALES_OVER","productStatusValue":"售罄","productTypeName":"常规固定期限产品","productTypeValue":"FIXED_TERM_PRODUCT","recommend":false,"remainingAmount":0,"saleAmount":2000,"saleEndTime":"2018-02-05 00:00:00","saleStartTime":"2018-02-02 12:21:57","startBuyTime":"0时0分","totalAmount":200000,"totalBuyNumber":3,"totalCopies":2000},{"activityDescription":"","appshouDesciption":"app","awardInterest":3,"baseAmount":100,"canJoin":true,"canJoinCode":0,"cornerType":"SALE_OVER","descriptionTitle":"车辆抵押","endBuyTime":"24时0分","finishRatio":100,"id":603,"idStr":"SSSSVhC1f","interest":7.8,"maturityDuration":"30天","maxAmount":1000,"maxInterest":7.8,"minAmount":1,"minInterest":7.8,"normalInterest":4.8,"productChannelId":2,"productInterestType":"固定收益","productName":"丰田抵押借款 第387期","productStatus":"SALES_OVER","productStatusValue":"售罄","productTypeName":"常规固定期限产品","productTypeValue":"FIXED_TERM_PRODUCT","recommend":false,"remainingAmount":0,"saleAmount":1000,"saleEndTime":"2018-02-04 00:00:00","saleStartTime":"2018-02-01 09:43:22","startBuyTime":"0时0分","totalAmount":100000,"totalBuyNumber":2,"totalCopies":1000},{"activityDescription":"","appshouDesciption":"app","awardInterest":3,"baseAmount":100,"canJoin":true,"canJoinCode":0,"cornerType":"LENDING","descriptionTitle":"车辆抵押","endBuyTime":"24时0分","finishRatio":100,"id":602,"idStr":"WWWWnMo50","interest":7.8,"maturityDuration":"30天","maxAmount":1000,"maxInterest":7.8,"minAmount":1,"minInterest":7.8,"normalInterest":4.8,"passTime":"2018-02-02 11:03:14","productChannelId":2,"productInterestType":"固定收益","productName":"丰田抵押借款 第386期","productStatus":"LENDING","productStatusValue":"还款中","productTypeName":"常规固定期限产品","productTypeValue":"FIXED_TERM_PRODUCT","recommend":false,"remainingAmount":0,"saleAmount":1000,"saleEndTime":"2018-02-03 00:00:00","saleStartTime":"2018-01-31 13:52:10","startBuyTime":"0时0分","startInterestDate":"2018-02-02","totalAmount":100000,"totalBuyNumber":2,"totalCopies":1000}]
		 * listIcon : [{"carId":1,"cityId":1,"id":1,"productId":36},{"carId":3,"cityId":2,"id":2,"productId":38},{"carId":20,"cityId":1,"id":3,"productId":41},{"carId":7,"cityId":1,"id":4,"productId":44},{"carId":8,"cityId":1,"id":5,"productId":45},{"carId":13,"cityId":0,"id":6,"productId":49},{"carId":13,"cityId":1,"id":7,"productId":50},{"carId":2,"cityId":0,"id":8,"productId":50},{"carId":13,"cityId":1,"id":9,"productId":51},{"carId":13,"cityId":1,"id":10,"productId":52},{"carId":2,"cityId":1,"id":11,"productId":53},{"carId":2,"cityId":1,"id":12,"productId":54},{"carId":0,"cityId":0,"id":13,"productId":55},{"carId":0,"cityId":0,"id":14,"productId":56},{"carId":2,"cityId":1,"id":15,"productId":57},{"carId":16,"cityId":1,"id":16,"productId":58},{"carId":16,"cityId":1,"id":17,"productId":59},{"carId":2,"cityId":1,"id":18,"productId":60},{"carId":1,"cityId":1,"id":19,"productId":61},{"carId":1,"cityId":1,"id":20,"productId":62},{"carId":18,"cityId":1,"id":21,"productId":64},{"carId":1,"cityId":1,"id":22,"productId":65},{"carId":21,"cityId":1,"id":23,"productId":66},{"carId":21,"cityId":1,"id":24,"productId":67},{"carId":5,"cityId":1,"id":25,"productId":68},{"carId":1,"cityId":1,"id":26,"productId":70},{"carId":2,"cityId":1,"id":27,"productId":71},{"carId":7,"cityId":1,"id":28,"productId":74},{"carId":5,"cityId":1,"id":29,"productId":77},{"carId":18,"cityId":1,"id":30,"productId":78},{"carId":53,"cityId":1,"id":31,"productId":79},{"carId":5,"cityId":2,"id":32,"productId":80},{"carId":18,"cityId":1,"id":33,"productId":81},{"carId":3,"cityId":1,"id":34,"productId":83},{"carId":1,"cityId":1,"id":35,"productId":87},{"carId":13,"cityId":1,"id":36,"productId":90},{"carId":3,"cityId":1,"id":37,"productId":91},{"carId":16,"cityId":1,"id":38,"productId":94},{"carId":1,"cityId":1,"id":39,"productId":97},{"carId":13,"cityId":1,"id":40,"productId":99},{"carId":3,"cityId":1,"id":41,"productId":100},{"carId":0,"cityId":0,"id":42,"productId":101},{"carId":16,"cityId":1,"id":43,"productId":102},{"carId":16,"cityId":1,"id":44,"productId":104},{"carId":22,"cityId":1,"id":45,"productId":105},{"carId":59,"cityId":1,"id":46,"productId":106},{"carId":0,"cityId":1,"id":47,"productId":107},{"carId":59,"cityId":1,"id":48,"productId":109},{"carId":0,"cityId":1,"id":49,"productId":111},{"carId":59,"cityId":1,"id":50,"productId":112},{"carId":7,"cityId":1,"id":51,"productId":114},{"carId":7,"cityId":1,"id":52,"productId":116},{"carId":7,"cityId":1,"id":53,"productId":117},{"carId":5,"cityId":2,"id":54,"productId":118},{"carId":7,"cityId":1,"id":55,"productId":119},{"carId":1,"cityId":1,"id":56,"productId":120},{"carId":1,"cityId":1,"id":57,"productId":121},{"carId":1,"cityId":1,"id":58,"productId":122},{"carId":53,"cityId":1,"id":59,"productId":123},{"carId":2,"cityId":1,"id":60,"productId":124},{"carId":7,"cityId":1,"id":61,"productId":125},{"carId":16,"cityId":2,"id":62,"productId":126},{"carId":7,"cityId":1,"id":63,"productId":127},{"carId":16,"cityId":2,"id":64,"productId":129},{"carId":1,"cityId":1,"id":65,"productId":131},{"carId":1,"cityId":1,"id":66,"productId":132},{"carId":7,"cityId":1,"id":67,"productId":132},{"carId":60,"cityId":1,"id":71,"productId":137},{"carId":7,"cityId":1,"id":69,"productId":135},{"carId":1,"cityId":1,"id":72,"productId":138},{"carId":7,"cityId":1,"id":73,"productId":139},{"carId":1,"cityId":1,"id":74,"productId":134},{"carId":13,"cityId":1,"id":75,"productId":140},{"carId":60,"cityId":1,"id":76,"productId":141},{"carId":18,"cityId":1,"id":77,"productId":142},{"carId":1,"cityId":1,"id":78,"productId":143},{"carId":1,"cityId":1,"id":79,"productId":144},{"carId":39,"cityId":1,"id":80,"productId":145},{"carId":39,"cityId":1,"id":81,"productId":146},{"carId":39,"cityId":1,"id":82,"productId":147},{"carId":39,"cityId":1,"id":83,"productId":148},{"carId":36,"cityId":1,"id":84,"productId":149},{"carId":16,"cityId":2,"id":85,"productId":150},{"carId":13,"cityId":1,"id":90,"productId":153},{"carId":13,"cityId":1,"id":87,"productId":152},{"carId":16,"cityId":1,"id":88,"productId":154},{"carId":13,"cityId":1,"id":91,"productId":155},{"carId":16,"cityId":1,"id":92,"productId":156},{"carId":2,"cityId":1,"id":93,"productId":158},{"carId":5,"cityId":1,"id":94,"productId":159},{"carId":2,"cityId":1,"id":95,"productId":160},{"carId":10,"cityId":1,"id":96,"productId":161},{"carId":1,"cityId":1,"id":97,"productId":162},{"carId":1,"cityId":1,"id":98,"productId":163},{"carId":1,"cityId":1,"id":99,"productId":164},{"carId":1,"cityId":1,"id":100,"productId":166},{"carId":16,"cityId":1,"id":101,"productId":167},{"carId":10,"cityId":1,"id":102,"productId":169},{"carId":13,"cityId":1,"id":103,"productId":170},{"carId":20,"cityId":1,"id":104,"productId":171},{"carId":20,"cityId":1,"id":105,"productId":172},{"carId":20,"cityId":1,"id":106,"productId":173},{"carId":20,"cityId":1,"id":107,"productId":174},{"carId":20,"cityId":1,"id":108,"productId":175},{"carId":20,"cityId":1,"id":109,"productId":176},{"carId":61,"cityId":1,"id":110,"productId":177},{"carId":61,"cityId":1,"id":111,"productId":178},{"carId":3,"cityId":1,"id":112,"productId":179},{"carId":3,"cityId":1,"id":113,"productId":180},{"carId":1,"cityId":1,"id":114,"productId":181},{"carId":7,"cityId":1,"id":115,"productId":182},{"carId":7,"cityId":1,"id":116,"productId":183},{"carId":7,"cityId":1,"id":117,"productId":185},{"carId":16,"cityId":1,"id":118,"productId":187},{"carId":1,"cityId":1,"id":119,"productId":188},{"carId":13,"cityId":1,"id":120,"productId":189},{"carId":1,"cityId":1,"id":121,"productId":190},{"carId":2,"cityId":1,"id":122,"productId":191},{"carId":62,"cityId":1,"id":123,"productId":192},{"carId":8,"cityId":1,"id":124,"productId":193},{"carId":1,"cityId":1,"id":125,"productId":194},{"carId":3,"cityId":1,"id":126,"productId":195},{"carId":1,"cityId":1,"id":127,"productId":196},{"carId":3,"cityId":1,"id":128,"productId":197},{"carId":1,"cityId":1,"id":129,"productId":198},{"carId":3,"cityId":1,"id":130,"productId":199},{"carId":18,"cityId":1,"id":131,"productId":200},{"carId":1,"cityId":1,"id":132,"productId":201},{"carId":10,"cityId":1,"id":133,"productId":202},{"carId":10,"cityId":1,"id":134,"productId":203},{"carId":1,"cityId":1,"id":135,"productId":204},{"carId":13,"cityId":1,"id":136,"productId":205},{"carId":7,"cityId":1,"id":137,"productId":206},{"carId":3,"cityId":1,"id":138,"productId":207},{"carId":2,"cityId":1,"id":139,"productId":208},{"carId":20,"cityId":1,"id":140,"productId":209},{"carId":2,"cityId":1,"id":141,"productId":210},{"carId":2,"cityId":1,"id":142,"productId":211},{"carId":20,"cityId":1,"id":143,"productId":212},{"carId":2,"cityId":1,"id":144,"productId":213},{"carId":13,"cityId":1,"id":145,"productId":214},{"carId":13,"cityId":1,"id":146,"productId":215},{"carId":11,"cityId":1,"id":147,"productId":216},{"carId":21,"cityId":1,"id":148,"productId":217},{"carId":7,"cityId":1,"id":149,"productId":219},{"carId":10,"cityId":1,"id":150,"productId":220},{"carId":10,"cityId":1,"id":151,"productId":221},{"carId":8,"cityId":1,"id":152,"productId":222},{"carId":10,"cityId":1,"id":153,"productId":223},{"carId":10,"cityId":1,"id":154,"productId":224},{"carId":10,"cityId":1,"id":155,"productId":225},{"carId":10,"cityId":1,"id":156,"productId":226},{"carId":1,"cityId":1,"id":157,"productId":228},{"carId":16,"cityId":1,"id":158,"productId":229},{"carId":1,"cityId":1,"id":159,"productId":230},{"carId":1,"cityId":1,"id":160,"productId":231},{"carId":1,"cityId":1,"id":161,"productId":233},{"carId":1,"cityId":1,"id":162,"productId":234},{"carId":16,"cityId":1,"id":163,"productId":235},{"carId":2,"cityId":1,"id":164,"productId":236},{"carId":10,"cityId":1,"id":165,"productId":237},{"carId":10,"cityId":1,"id":166,"productId":238},{"carId":7,"cityId":1,"id":167,"productId":239},{"carId":1,"cityId":1,"id":168,"productId":240},{"carId":1,"cityId":1,"id":169,"productId":241},{"carId":1,"cityId":1,"id":170,"productId":242},{"carId":1,"cityId":1,"id":171,"productId":243},{"carId":1,"cityId":1,"id":172,"productId":244},{"carId":1,"cityId":1,"id":173,"productId":245},{"carId":10,"cityId":1,"id":174,"productId":246},{"carId":10,"cityId":1,"id":175,"productId":247},{"carId":1,"cityId":1,"id":176,"productId":248},{"carId":24,"cityId":1,"id":177,"productId":249},{"carId":24,"cityId":1,"id":178,"productId":250},{"carId":24,"cityId":1,"id":179,"productId":251},{"carId":8,"cityId":1,"id":180,"productId":252},{"carId":22,"cityId":1,"id":181,"productId":253},{"carId":1,"cityId":1,"id":182,"productId":254},{"carId":1,"cityId":1,"id":183,"productId":255},{"carId":29,"cityId":1,"id":184,"productId":256},{"carId":18,"cityId":1,"id":185,"productId":257},{"carId":1,"cityId":1,"id":186,"productId":258},{"carId":1,"cityId":1,"id":187,"productId":259},{"carId":16,"cityId":1,"id":188,"productId":260},{"carId":16,"cityId":1,"id":189,"productId":261},{"carId":13,"cityId":1,"id":190,"productId":262},{"carId":8,"cityId":1,"id":191,"productId":264},{"carId":1,"cityId":1,"id":192,"productId":265},{"carId":1,"cityId":1,"id":193,"productId":266},{"carId":21,"cityId":1,"id":194,"productId":267},{"carId":22,"cityId":1,"id":195,"productId":268},{"carId":22,"cityId":1,"id":196,"productId":269},{"carId":2,"cityId":1,"id":197,"productId":270},{"carId":18,"cityId":1,"id":198,"productId":271},{"carId":18,"cityId":1,"id":199,"productId":272},{"carId":1,"cityId":1,"id":200,"productId":273},{"carId":2,"cityId":1,"id":201,"productId":274},{"carId":1,"cityId":1,"id":202,"productId":275},{"carId":0,"cityId":1,"id":203,"productId":276},{"carId":18,"cityId":1,"id":204,"productId":277},{"carId":1,"cityId":1,"id":205,"productId":278},{"carId":1,"cityId":1,"id":206,"productId":280},{"carId":1,"cityId":1,"id":207,"productId":281},{"carId":1,"cityId":1,"id":208,"productId":282},{"carId":10,"cityId":1,"id":209,"productId":283},{"carId":1,"cityId":1,"id":210,"productId":284},{"carId":1,"cityId":1,"id":211,"productId":285},{"carId":18,"cityId":1,"id":212,"productId":286},{"carId":8,"cityId":1,"id":213,"productId":287},{"carId":16,"cityId":1,"id":214,"productId":288},{"carId":7,"cityId":1,"id":215,"productId":289},{"carId":18,"cityId":1,"id":216,"productId":290},{"carId":13,"cityId":1,"id":217,"productId":291},{"carId":16,"cityId":1,"id":218,"productId":292},{"carId":7,"cityId":1,"id":219,"productId":293},{"carId":7,"cityId":1,"id":220,"productId":294},{"carId":18,"cityId":1,"id":221,"productId":295},{"carId":1,"cityId":1,"id":222,"productId":296},{"carId":2,"cityId":1,"id":223,"productId":297},{"carId":7,"cityId":1,"id":224,"productId":298},{"carId":1,"cityId":1,"id":225,"productId":299},{"carId":7,"cityId":1,"id":226,"productId":302},{"carId":1,"cityId":1,"id":227,"productId":303},{"carId":1,"cityId":1,"id":228,"productId":304},{"carId":1,"cityId":1,"id":229,"productId":305},{"carId":22,"cityId":1,"id":230,"productId":306},{"carId":3,"cityId":1,"id":231,"productId":307},{"carId":55,"cityId":1,"id":232,"productId":308},{"carId":55,"cityId":1,"id":233,"productId":309},{"carId":20,"cityId":1,"id":234,"productId":310},{"carId":1,"cityId":1,"id":235,"productId":311},{"carId":56,"cityId":1,"id":236,"productId":312},{"carId":53,"cityId":1,"id":237,"productId":313},{"carId":1,"cityId":1,"id":238,"productId":314},{"carId":2,"cityId":1,"id":239,"productId":315},{"carId":18,"cityId":1,"id":240,"productId":317},{"carId":1,"cityId":1,"id":241,"productId":318},{"carId":1,"cityId":1,"id":242,"productId":319},{"carId":1,"cityId":2,"id":243,"productId":320},{"carId":1,"cityId":1,"id":244,"productId":321},{"carId":1,"cityId":1,"id":245,"productId":322},{"carId":18,"cityId":1,"id":246,"productId":323},{"carId":1,"cityId":1,"id":247,"productId":324},{"carId":22,"cityId":1,"id":248,"productId":325},{"carId":24,"cityId":1,"id":249,"productId":326},{"carId":1,"cityId":1,"id":250,"productId":327},{"carId":5,"cityId":1,"id":251,"productId":328},{"carId":5,"cityId":1,"id":252,"productId":329},{"carId":1,"cityId":1,"id":253,"productId":330},{"carId":20,"cityId":1,"id":254,"productId":331},{"carId":1,"cityId":1,"id":255,"productId":332},{"carId":53,"cityId":1,"id":256,"productId":333},{"carId":1,"cityId":1,"id":257,"productId":334},{"carId":1,"cityId":1,"id":258,"productId":335},{"carId":1,"cityId":1,"id":259,"productId":336},{"carId":8,"cityId":1,"id":260,"productId":337},{"carId":1,"cityId":1,"id":261,"productId":338},{"carId":1,"cityId":1,"id":262,"productId":339},{"carId":61,"cityId":1,"id":263,"productId":340},{"carId":1,"cityId":1,"id":264,"productId":341},{"carId":1,"cityId":1,"id":265,"productId":342},{"carId":8,"cityId":1,"id":266,"productId":343},{"carId":63,"cityId":1,"id":267,"productId":346},{"carId":18,"cityId":1,"id":268,"productId":347},{"carId":13,"cityId":1,"id":269,"productId":348},{"carId":1,"cityId":1,"id":270,"productId":349},{"carId":7,"cityId":1,"id":271,"productId":350},{"carId":10,"cityId":1,"id":272,"productId":351},{"carId":1,"cityId":1,"id":273,"productId":352},{"carId":16,"cityId":1,"id":274,"productId":353},{"carId":2,"cityId":1,"id":275,"productId":355},{"carId":8,"cityId":1,"id":276,"productId":356},{"carId":10,"cityId":1,"id":277,"productId":357},{"carId":1,"cityId":1,"id":278,"productId":358},{"carId":24,"cityId":1,"id":279,"productId":360},{"carId":1,"cityId":2,"id":280,"productId":361},{"carId":1,"cityId":1,"id":281,"productId":362},{"carId":0,"cityId":0,"id":282,"productId":363},{"carId":7,"cityId":1,"id":283,"productId":364},{"carId":21,"cityId":1,"id":284,"productId":365},{"carId":18,"cityId":1,"id":285,"productId":366},{"carId":20,"cityId":1,"id":286,"productId":368},{"carId":20,"cityId":1,"id":287,"productId":369},{"carId":20,"cityId":1,"id":288,"productId":370},{"carId":20,"cityId":1,"id":289,"productId":371},{"carId":61,"cityId":1,"id":290,"productId":372},{"carId":61,"cityId":1,"id":291,"productId":373},{"carId":25,"cityId":2,"id":292,"productId":374},{"carId":13,"cityId":1,"id":293,"productId":375},{"carId":10,"cityId":1,"id":294,"productId":376},{"carId":18,"cityId":1,"id":295,"productId":378},{"carId":7,"cityId":1,"id":296,"productId":379},{"carId":53,"cityId":1,"id":297,"productId":380},{"carId":3,"cityId":1,"id":298,"productId":381},{"carId":1,"cityId":1,"id":299,"productId":382},{"carId":18,"cityId":1,"id":300,"productId":384},{"carId":8,"cityId":1,"id":301,"productId":385},{"carId":1,"cityId":1,"id":302,"productId":386},{"carId":13,"cityId":2,"id":303,"productId":387},{"carId":18,"cityId":1,"id":304,"productId":388},{"carId":10,"cityId":1,"id":305,"productId":389},{"carId":0,"cityId":1,"id":306,"productId":390},{"carId":8,"cityId":1,"id":307,"productId":391},{"carId":7,"cityId":1,"id":308,"productId":392},{"carId":21,"cityId":1,"id":309,"productId":393},{"carId":1,"cityId":1,"id":310,"productId":394},{"carId":1,"cityId":1,"id":311,"productId":395},{"carId":11,"cityId":1,"id":312,"productId":396},{"carId":10,"cityId":1,"id":313,"productId":397},{"carId":18,"cityId":1,"id":314,"productId":398},{"carId":18,"cityId":1,"id":315,"productId":399},{"carId":15,"cityId":1,"id":316,"productId":400},{"carId":1,"cityId":1,"id":317,"productId":401},{"carId":29,"cityId":1,"id":318,"productId":402},{"carId":10,"cityId":1,"id":319,"productId":403},{"carId":64,"cityId":2,"id":320,"productId":404},{"carId":7,"cityId":1,"id":321,"productId":405},{"carId":16,"cityId":1,"id":322,"productId":406},{"carId":7,"cityId":1,"id":323,"productId":407},{"carId":1,"cityId":1,"id":324,"productId":408},{"carId":1,"cityId":2,"id":325,"productId":409},{"carId":3,"cityId":1,"id":326,"productId":410},{"carId":16,"cityId":1,"id":327,"productId":411},{"carId":8,"cityId":1,"id":328,"productId":412},{"carId":11,"cityId":1,"id":329,"productId":413},{"carId":1,"cityId":1,"id":330,"productId":414},{"carId":7,"cityId":1,"id":331,"productId":415},{"carId":1,"cityId":1,"id":332,"productId":416},{"carId":20,"cityId":1,"id":333,"productId":417},{"carId":16,"cityId":1,"id":334,"productId":418},{"carId":16,"cityId":1,"id":335,"productId":419},{"carId":16,"cityId":1,"id":336,"productId":420},{"carId":16,"cityId":1,"id":337,"productId":421},{"carId":13,"cityId":1,"id":338,"productId":422},{"carId":13,"cityId":1,"id":339,"productId":423},{"carId":1,"cityId":1,"id":340,"productId":424},{"carId":1,"cityId":1,"id":341,"productId":425},{"carId":7,"cityId":1,"id":342,"productId":426},{"carId":1,"cityId":1,"id":343,"productId":427},{"carId":3,"cityId":1,"id":344,"productId":428},{"carId":1,"cityId":1,"id":345,"productId":429},{"carId":15,"cityId":1,"id":346,"productId":430},{"carId":1,"cityId":1,"id":347,"productId":431},{"carId":7,"cityId":1,"id":348,"productId":432},{"carId":7,"cityId":1,"id":349,"productId":433},{"carId":1,"cityId":1,"id":350,"productId":434},{"carId":13,"cityId":1,"id":351,"productId":435},{"carId":13,"cityId":1,"id":352,"productId":436},{"carId":1,"cityId":1,"id":353,"productId":437},{"carId":1,"cityId":1,"id":354,"productId":439},{"carId":8,"cityId":1,"id":355,"productId":440},{"carId":1,"cityId":1,"id":356,"productId":441},{"carId":7,"cityId":1,"id":357,"productId":442},{"carId":53,"cityId":1,"id":358,"productId":443},{"carId":3,"cityId":1,"id":359,"productId":444},{"carId":13,"cityId":1,"id":360,"productId":445},{"carId":8,"cityId":1,"id":361,"productId":446},{"carId":3,"cityId":1,"id":362,"productId":447},{"carId":10,"cityId":1,"id":363,"productId":448},{"carId":11,"cityId":1,"id":364,"productId":449},{"carId":13,"cityId":1,"id":365,"productId":450},{"carId":1,"cityId":1,"id":366,"productId":451},{"carId":3,"cityId":1,"id":367,"productId":452},{"carId":3,"cityId":1,"id":368,"productId":453},{"carId":49,"cityId":1,"id":369,"productId":454},{"carId":13,"cityId":1,"id":370,"productId":455},{"carId":49,"cityId":1,"id":371,"productId":457},{"carId":49,"cityId":1,"id":372,"productId":458},{"carId":13,"cityId":1,"id":373,"productId":459},{"carId":13,"cityId":1,"id":374,"productId":460},{"carId":3,"cityId":1,"id":375,"productId":461},{"carId":8,"cityId":1,"id":376,"productId":462},{"carId":1,"cityId":1,"id":377,"productId":463},{"carId":16,"cityId":1,"id":378,"productId":464},{"carId":1,"cityId":1,"id":379,"productId":465},{"carId":1,"cityId":1,"id":380,"productId":466},{"carId":8,"cityId":1,"id":381,"productId":467},{"carId":20,"cityId":1,"id":382,"productId":468},{"carId":16,"cityId":1,"id":383,"productId":469},{"carId":7,"cityId":1,"id":384,"productId":470},{"carId":1,"cityId":1,"id":385,"productId":471},{"carId":1,"cityId":1,"id":386,"productId":472},{"carId":8,"cityId":1,"id":387,"productId":473},{"carId":53,"cityId":1,"id":388,"productId":474},{"carId":11,"cityId":1,"id":389,"productId":475},{"carId":8,"cityId":1,"id":390,"productId":476},{"carId":3,"cityId":1,"id":391,"productId":477},{"carId":8,"cityId":1,"id":392,"productId":478},{"carId":10,"cityId":1,"id":393,"productId":479},{"carId":11,"cityId":1,"id":394,"productId":480},{"carId":5,"cityId":1,"id":395,"productId":481},{"carId":7,"cityId":1,"id":396,"productId":482},{"carId":8,"cityId":1,"id":397,"productId":483},{"carId":3,"cityId":1,"id":398,"productId":484},{"carId":3,"cityId":1,"id":399,"productId":485},{"carId":16,"cityId":1,"id":400,"productId":486},{"carId":3,"cityId":1,"id":401,"productId":487},{"carId":8,"cityId":1,"id":402,"productId":488},{"carId":10,"cityId":1,"id":403,"productId":489},{"carId":3,"cityId":2,"id":404,"productId":490},{"carId":11,"cityId":1,"id":405,"productId":491},{"carId":1,"cityId":1,"id":406,"productId":492},{"carId":13,"cityId":1,"id":407,"productId":493},{"carId":8,"cityId":1,"id":408,"productId":494},{"carId":5,"cityId":1,"id":409,"productId":495},{"carId":10,"cityId":1,"id":410,"productId":496},{"carId":1,"cityId":1,"id":411,"productId":497},{"carId":16,"cityId":1,"id":412,"productId":498},{"carId":1,"cityId":1,"id":413,"productId":499},{"carId":1,"cityId":1,"id":414,"productId":500},{"carId":8,"cityId":1,"id":415,"productId":501},{"carId":1,"cityId":1,"id":416,"productId":502},{"carId":15,"cityId":1,"id":417,"productId":503},{"carId":5,"cityId":1,"id":418,"productId":504},{"carId":3,"cityId":1,"id":419,"productId":505},{"carId":3,"cityId":1,"id":420,"productId":506},{"carId":16,"cityId":1,"id":421,"productId":507},{"carId":15,"cityId":1,"id":422,"productId":508},{"carId":1,"cityId":1,"id":423,"productId":510},{"carId":17,"cityId":2,"id":424,"productId":511},{"carId":7,"cityId":1,"id":425,"productId":512},{"carId":1,"cityId":1,"id":426,"productId":513},{"carId":20,"cityId":1,"id":427,"productId":514},{"carId":65,"cityId":1,"id":428,"productId":515},{"carId":16,"cityId":1,"id":429,"productId":516},{"carId":1,"cityId":1,"id":430,"productId":517},{"carId":7,"cityId":1,"id":431,"productId":518},{"carId":7,"cityId":1,"id":432,"productId":519},{"carId":16,"cityId":1,"id":433,"productId":520},{"carId":29,"cityId":1,"id":434,"productId":521},{"carId":20,"cityId":1,"id":435,"productId":522},{"carId":63,"cityId":1,"id":436,"productId":525},{"carId":1,"cityId":1,"id":437,"productId":526},{"carId":13,"cityId":1,"id":438,"productId":527},{"carId":1,"cityId":1,"id":439,"productId":528},{"carId":1,"cityId":1,"id":440,"productId":529},{"carId":7,"cityId":1,"id":441,"productId":530},{"carId":1,"cityId":1,"id":442,"productId":531},{"carId":3,"cityId":1,"id":443,"productId":532},{"carId":1,"cityId":1,"id":444,"productId":533},{"carId":1,"cityId":1,"id":445,"productId":534},{"carId":2,"cityId":1,"id":446,"productId":535},{"carId":18,"cityId":1,"id":447,"productId":536},{"carId":1,"cityId":1,"id":448,"productId":537},{"carId":13,"cityId":1,"id":449,"productId":538},{"carId":10,"cityId":1,"id":450,"productId":539},{"carId":50,"cityId":1,"id":451,"productId":542},{"carId":50,"cityId":1,"id":452,"productId":543},{"carId":16,"cityId":1,"id":453,"productId":544},{"carId":3,"cityId":1,"id":454,"productId":545},{"carId":1,"cityId":1,"id":455,"productId":546},{"carId":1,"cityId":1,"id":456,"productId":547},{"carId":3,"cityId":1,"id":457,"productId":548},{"carId":1,"cityId":1,"id":458,"productId":549},{"carId":8,"cityId":1,"id":459,"productId":550},{"carId":1,"cityId":2,"id":460,"productId":551},{"carId":10,"cityId":1,"id":461,"productId":552},{"carId":1,"cityId":1,"id":462,"productId":553},{"carId":16,"cityId":1,"id":463,"productId":554},{"carId":16,"cityId":1,"id":464,"productId":555},{"carId":2,"cityId":1,"id":465,"productId":556},{"carId":60,"cityId":1,"id":466,"productId":557},{"carId":3,"cityId":1,"id":467,"productId":558},{"carId":1,"cityId":1,"id":468,"productId":559},{"carId":18,"cityId":1,"id":469,"productId":560},{"carId":7,"cityId":1,"id":470,"productId":561},{"carId":7,"cityId":1,"id":471,"productId":562},{"carId":16,"cityId":1,"id":472,"productId":563},{"carId":8,"cityId":1,"id":473,"productId":564},{"carId":29,"cityId":1,"id":474,"productId":565},{"carId":10,"cityId":1,"id":475,"productId":566},{"carId":54,"cityId":1,"id":476,"productId":567},{"carId":49,"cityId":1,"id":477,"productId":568},{"carId":1,"cityId":1,"id":478,"productId":569},{"carId":1,"cityId":1,"id":479,"productId":570},{"carId":16,"cityId":1,"id":480,"productId":571},{"carId":7,"cityId":1,"id":481,"productId":572},{"carId":49,"cityId":1,"id":482,"productId":573},{"carId":10,"cityId":1,"id":483,"productId":574},{"carId":8,"cityId":1,"id":484,"productId":575},{"carId":3,"cityId":1,"id":485,"productId":576},{"carId":10,"cityId":1,"id":486,"productId":577},{"carId":49,"cityId":1,"id":487,"productId":578},{"carId":53,"cityId":1,"id":488,"productId":579},{"carId":1,"cityId":1,"id":489,"productId":580},{"carId":22,"cityId":1,"id":490,"productId":581},{"carId":67,"cityId":2,"id":491,"productId":582},{"carId":67,"cityId":2,"id":492,"productId":583},{"carId":1,"cityId":1,"id":493,"productId":584},{"carId":1,"cityId":1,"id":494,"productId":585},{"carId":13,"cityId":1,"id":495,"productId":586},{"carId":11,"cityId":1,"id":496,"productId":587},{"carId":49,"cityId":1,"id":497,"productId":588},{"carId":3,"cityId":1,"id":498,"productId":589},{"carId":2,"cityId":1,"id":499,"productId":590},{"carId":2,"cityId":1,"id":500,"productId":591},{"carId":13,"cityId":1,"id":501,"productId":592},{"carId":13,"cityId":1,"id":502,"productId":593},{"carId":16,"cityId":1,"id":503,"productId":594},{"carId":11,"cityId":1,"id":504,"productId":595},{"carId":11,"cityId":1,"id":505,"productId":596},{"carId":5,"cityId":1,"id":506,"productId":597},{"carId":5,"cityId":1,"id":507,"productId":598},{"carId":3,"cityId":1,"id":508,"productId":599},{"carId":1,"cityId":1,"id":509,"productId":600},{"carId":13,"cityId":1,"id":510,"productId":601},{"carId":1,"cityId":1,"id":511,"productId":602},{"carId":1,"cityId":1,"id":512,"productId":603},{"carId":16,"cityId":1,"id":513,"productId":604},{"carId":29,"cityId":1,"id":514,"productId":605},{"carId":16,"cityId":1,"id":515,"productId":606},{"carId":1,"cityId":1,"id":516,"productId":607},{"carId":8,"cityId":1,"id":517,"productId":608},{"carId":1,"cityId":1,"id":518,"productId":609},{"carId":3,"cityId":1,"id":519,"productId":610},{"carId":7,"cityId":1,"id":520,"productId":611}]
		 * total : 301
		 */

		private int total;
		private ArrayList<ListBean> list;
		private ArrayList<List1Bean> list1;
		private ArrayList<ListIconBean> listIcon;

		public static DataBean objectFromData(String str) {

			return new Gson().fromJson(str, DataBean.class);
		}

		public int getTotal() {
			return total;
		}

		public void setTotal(int total) {
			this.total = total;
		}

		public ArrayList<ListBean> getList() {
			return list;
		}

		public void setList(ArrayList<ListBean> list) {
			this.list = list;
		}

		public List<List1Bean> getList1() {
			return list1;
		}

		public void setList1(ArrayList<List1Bean> list1) {
			this.list1 = list1;
		}

		public List<ListIconBean> getListIcon() {
			return listIcon;
		}

		public void setListIcon(ArrayList<ListIconBean> listIcon) {
			this.listIcon = listIcon;
		}

		public static class ListBean {
			/**
			 * activityDescription :
			 * appshouDesciption : app
			 * baseAmount : 100
			 * canJoin : true
			 * canJoinCode : 0
			 * cornerType : TASTE
			 * descriptionTitle : 车辆抵押
			 * endBuyTime : 24时0分
			 * finishRatio : 70
			 * id : 605
			 * idStr : eeeegqq9k
			 * interest : 14
			 * maturityDuration : 10天
			 * maxAmount : 100
			 * maxInterest : 14
			 * minAmount : 1
			 * minInterest : 14
			 * normalInterest : 14
			 * productChannelId : 2
			 * productInterestType : 固定收益
			 * productName : 比亚迪抵押借款 第389期
			 * productStatus : SALES
			 * productStatusValue : 销售中
			 * productTypeName : 短期体验产品
			 * productTypeValue : SHORT_TASTE_PRODUCT
			 * recommend : false
			 * remainingAmount : 30
			 * saleAmount : 70
			 * saleEndTime : 2018-02-07 00:00:00
			 * saleStartTime : 2018-02-04 13:27:36
			 * startBuyTime : 0时0分
			 * totalAmount : 10000
			 * totalBuyNumber : 7
			 * totalCopies : 100
			 * awardInterest : 3
			 * passTime : 2017-07-07 18:32:49
			 * startInterestDate : 2017-07-07
			 */

			private String activityDescription;
			private String appshouDesciption;
			private int baseAmount;
			private boolean canJoin;
			private int canJoinCode;
			private String cornerType;
			private String descriptionTitle;
			private String endBuyTime;
			private String finishRatio;
			private int id;
			private String idStr;
			private double interest;
			private String maturityDuration;
			private int maxAmount;
			private int maxInterest;
			private int minAmount;
			private int minInterest;
			private int normalInterest;
			private int productChannelId;
			private String productInterestType;
			private String productName;
			private String productStatus;
			private String productStatusValue;
			private String productTypeName;
			private String productTypeValue;
			private boolean recommend;
			private int remainingAmount;
			private int saleAmount;
			private String saleEndTime;
			private String saleStartTime;
			private String startBuyTime;
			private int totalAmount;
			private int totalBuyNumber;
			private int totalCopies;
			private int awardInterest;
			private String passTime;
			private String startInterestDate;

			public static ListBean objectFromData(String str) {

				return new Gson().fromJson(str, ListBean.class);
			}

			public String getActivityDescription() {
				return activityDescription;
			}

			public void setActivityDescription(String activityDescription) {
				this.activityDescription = activityDescription;
			}

			public String getAppshouDesciption() {
				return appshouDesciption;
			}

			public void setAppshouDesciption(String appshouDesciption) {
				this.appshouDesciption = appshouDesciption;
			}

			public int getBaseAmount() {
				return baseAmount;
			}

			public void setBaseAmount(int baseAmount) {
				this.baseAmount = baseAmount;
			}

			public boolean isCanJoin() {
				return canJoin;
			}

			public void setCanJoin(boolean canJoin) {
				this.canJoin = canJoin;
			}

			public int getCanJoinCode() {
				return canJoinCode;
			}

			public void setCanJoinCode(int canJoinCode) {
				this.canJoinCode = canJoinCode;
			}

			public String getCornerType() {
				return cornerType;
			}

			public void setCornerType(String cornerType) {
				this.cornerType = cornerType;
			}

			public String getDescriptionTitle() {
				return descriptionTitle;
			}

			public void setDescriptionTitle(String descriptionTitle) {
				this.descriptionTitle = descriptionTitle;
			}

			public String getEndBuyTime() {
				return endBuyTime;
			}

			public void setEndBuyTime(String endBuyTime) {
				this.endBuyTime = endBuyTime;
			}

			public String getFinishRatio() {
				return finishRatio;
			}

			public void setFinishRatio(String finishRatio) {
				this.finishRatio = finishRatio;
			}

			public int getId() {
				return id;
			}

			public void setId(int id) {
				this.id = id;
			}

			public String getIdStr() {
				return idStr;
			}

			public void setIdStr(String idStr) {
				this.idStr = idStr;
			}

			public double getInterest() {
				return interest;
			}

			public void setInterest(double interest) {
				this.interest = interest;
			}

			public String getMaturityDuration() {
				return maturityDuration;
			}

			public void setMaturityDuration(String maturityDuration) {
				this.maturityDuration = maturityDuration;
			}

			public int getMaxAmount() {
				return maxAmount;
			}

			public void setMaxAmount(int maxAmount) {
				this.maxAmount = maxAmount;
			}

			public int getMaxInterest() {
				return maxInterest;
			}

			public void setMaxInterest(int maxInterest) {
				this.maxInterest = maxInterest;
			}

			public int getMinAmount() {
				return minAmount;
			}

			public void setMinAmount(int minAmount) {
				this.minAmount = minAmount;
			}

			public int getMinInterest() {
				return minInterest;
			}

			public void setMinInterest(int minInterest) {
				this.minInterest = minInterest;
			}

			public int getNormalInterest() {
				return normalInterest;
			}

			public void setNormalInterest(int normalInterest) {
				this.normalInterest = normalInterest;
			}

			public int getProductChannelId() {
				return productChannelId;
			}

			public void setProductChannelId(int productChannelId) {
				this.productChannelId = productChannelId;
			}

			public String getProductInterestType() {
				return productInterestType;
			}

			public void setProductInterestType(String productInterestType) {
				this.productInterestType = productInterestType;
			}

			public String getProductName() {
				return productName;
			}

			public void setProductName(String productName) {
				this.productName = productName;
			}

			public String getProductStatus() {
				return productStatus;
			}

			public void setProductStatus(String productStatus) {
				this.productStatus = productStatus;
			}

			public String getProductStatusValue() {
				return productStatusValue;
			}

			public void setProductStatusValue(String productStatusValue) {
				this.productStatusValue = productStatusValue;
			}

			public String getProductTypeName() {
				return productTypeName;
			}

			public void setProductTypeName(String productTypeName) {
				this.productTypeName = productTypeName;
			}

			public String getProductTypeValue() {
				return productTypeValue;
			}

			public void setProductTypeValue(String productTypeValue) {
				this.productTypeValue = productTypeValue;
			}

			public boolean isRecommend() {
				return recommend;
			}

			public void setRecommend(boolean recommend) {
				this.recommend = recommend;
			}

			public int getRemainingAmount() {
				return remainingAmount;
			}

			public void setRemainingAmount(int remainingAmount) {
				this.remainingAmount = remainingAmount;
			}

			public int getSaleAmount() {
				return saleAmount;
			}

			public void setSaleAmount(int saleAmount) {
				this.saleAmount = saleAmount;
			}

			public String getSaleEndTime() {
				return saleEndTime;
			}

			public void setSaleEndTime(String saleEndTime) {
				this.saleEndTime = saleEndTime;
			}

			public String getSaleStartTime() {
				return saleStartTime;
			}

			public void setSaleStartTime(String saleStartTime) {
				this.saleStartTime = saleStartTime;
			}

			public String getStartBuyTime() {
				return startBuyTime;
			}

			public void setStartBuyTime(String startBuyTime) {
				this.startBuyTime = startBuyTime;
			}

			public int getTotalAmount() {
				return totalAmount;
			}

			public void setTotalAmount(int totalAmount) {
				this.totalAmount = totalAmount;
			}

			public int getTotalBuyNumber() {
				return totalBuyNumber;
			}

			public void setTotalBuyNumber(int totalBuyNumber) {
				this.totalBuyNumber = totalBuyNumber;
			}

			public int getTotalCopies() {
				return totalCopies;
			}

			public void setTotalCopies(int totalCopies) {
				this.totalCopies = totalCopies;
			}

			public int getAwardInterest() {
				return awardInterest;
			}

			public void setAwardInterest(int awardInterest) {
				this.awardInterest = awardInterest;
			}

			public String getPassTime() {
				return passTime;
			}

			public void setPassTime(String passTime) {
				this.passTime = passTime;
			}

			public String getStartInterestDate() {
				return startInterestDate;
			}

			public void setStartInterestDate(String startInterestDate) {
				this.startInterestDate = startInterestDate;
			}
		}

		public static class List1Bean {
			/**
			 * activityDescription :
			 * appshouDesciption : app
			 * awardInterest : 3
			 * baseAmount : 100
			 * canJoin : true
			 * canJoinCode : 0
			 * cornerType : ACTIVITY
			 * descriptionTitle : 车辆抵押
			 * endBuyTime : 24时0分
			 * finishRatio : 61.54
			 * id : 611
			 * idStr : SSSSoSg1f
			 * interest : 7.8
			 * maturityDuration : 30天
			 * maxAmount : 1300
			 * maxInterest : 7.8
			 * minAmount : 1
			 * minInterest : 7.8
			 * normalInterest : 4.8
			 * productChannelId : 2
			 * productInterestType : 固定收益
			 * productName : 奥迪抵押借款 第395期
			 * productStatus : SALES
			 * productStatusValue : 销售中
			 * productTypeName : 常规固定期限产品
			 * productTypeValue : FIXED_TERM_PRODUCT
			 * recommend : false
			 * remainingAmount : 500
			 * saleAmount : 800
			 * saleEndTime : 2018-02-08 00:00:00
			 * saleStartTime : 2018-02-05 14:16:44
			 * startBuyTime : 0时0分
			 * totalAmount : 130000
			 * totalBuyNumber : 1
			 * totalCopies : 1300
			 * passTime : 2018-02-02 11:03:14
			 * startInterestDate : 2018-02-02
			 */

			private String activityDescription;
			private String appshouDesciption;
			private int awardInterest;
			private int baseAmount;
			private boolean canJoin;
			private int canJoinCode;
			private String cornerType;
			private String descriptionTitle;
			private String endBuyTime;
			private double finishRatio;
			private int id;
			private String idStr;
			private double interest;
			private String maturityDuration;
			private int maxAmount;
			private double maxInterest;
			private int minAmount;
			private double minInterest;
			private double normalInterest;
			private int productChannelId;
			private String productInterestType;
			private String productName;
			private String productStatus;
			private String productStatusValue;
			private String productTypeName;
			private String productTypeValue;
			private boolean recommend;
			private int remainingAmount;
			private int saleAmount;
			private String saleEndTime;
			private String saleStartTime;
			private String startBuyTime;
			private int totalAmount;
			private int totalBuyNumber;
			private int totalCopies;
			private String passTime;
			private String startInterestDate;

			public static List1Bean objectFromData(String str) {

				return new Gson().fromJson(str, List1Bean.class);
			}

			public String getActivityDescription() {
				return activityDescription;
			}

			public void setActivityDescription(String activityDescription) {
				this.activityDescription = activityDescription;
			}

			public String getAppshouDesciption() {
				return appshouDesciption;
			}

			public void setAppshouDesciption(String appshouDesciption) {
				this.appshouDesciption = appshouDesciption;
			}

			public int getAwardInterest() {
				return awardInterest;
			}

			public void setAwardInterest(int awardInterest) {
				this.awardInterest = awardInterest;
			}

			public int getBaseAmount() {
				return baseAmount;
			}

			public void setBaseAmount(int baseAmount) {
				this.baseAmount = baseAmount;
			}

			public boolean isCanJoin() {
				return canJoin;
			}

			public void setCanJoin(boolean canJoin) {
				this.canJoin = canJoin;
			}

			public int getCanJoinCode() {
				return canJoinCode;
			}

			public void setCanJoinCode(int canJoinCode) {
				this.canJoinCode = canJoinCode;
			}

			public String getCornerType() {
				return cornerType;
			}

			public void setCornerType(String cornerType) {
				this.cornerType = cornerType;
			}

			public String getDescriptionTitle() {
				return descriptionTitle;
			}

			public void setDescriptionTitle(String descriptionTitle) {
				this.descriptionTitle = descriptionTitle;
			}

			public String getEndBuyTime() {
				return endBuyTime;
			}

			public void setEndBuyTime(String endBuyTime) {
				this.endBuyTime = endBuyTime;
			}

			public double getFinishRatio() {
				return finishRatio;
			}

			public void setFinishRatio(double finishRatio) {
				this.finishRatio = finishRatio;
			}

			public int getId() {
				return id;
			}

			public void setId(int id) {
				this.id = id;
			}

			public String getIdStr() {
				return idStr;
			}

			public void setIdStr(String idStr) {
				this.idStr = idStr;
			}

			public double getInterest() {
				return interest;
			}

			public void setInterest(double interest) {
				this.interest = interest;
			}

			public String getMaturityDuration() {
				return maturityDuration;
			}

			public void setMaturityDuration(String maturityDuration) {
				this.maturityDuration = maturityDuration;
			}

			public int getMaxAmount() {
				return maxAmount;
			}

			public void setMaxAmount(int maxAmount) {
				this.maxAmount = maxAmount;
			}

			public double getMaxInterest() {
				return maxInterest;
			}

			public void setMaxInterest(double maxInterest) {
				this.maxInterest = maxInterest;
			}

			public int getMinAmount() {
				return minAmount;
			}

			public void setMinAmount(int minAmount) {
				this.minAmount = minAmount;
			}

			public double getMinInterest() {
				return minInterest;
			}

			public void setMinInterest(double minInterest) {
				this.minInterest = minInterest;
			}

			public double getNormalInterest() {
				return normalInterest;
			}

			public void setNormalInterest(double normalInterest) {
				this.normalInterest = normalInterest;
			}

			public int getProductChannelId() {
				return productChannelId;
			}

			public void setProductChannelId(int productChannelId) {
				this.productChannelId = productChannelId;
			}

			public String getProductInterestType() {
				return productInterestType;
			}

			public void setProductInterestType(String productInterestType) {
				this.productInterestType = productInterestType;
			}

			public String getProductName() {
				return productName;
			}

			public void setProductName(String productName) {
				this.productName = productName;
			}

			public String getProductStatus() {
				return productStatus;
			}

			public void setProductStatus(String productStatus) {
				this.productStatus = productStatus;
			}

			public String getProductStatusValue() {
				return productStatusValue;
			}

			public void setProductStatusValue(String productStatusValue) {
				this.productStatusValue = productStatusValue;
			}

			public String getProductTypeName() {
				return productTypeName;
			}

			public void setProductTypeName(String productTypeName) {
				this.productTypeName = productTypeName;
			}

			public String getProductTypeValue() {
				return productTypeValue;
			}

			public void setProductTypeValue(String productTypeValue) {
				this.productTypeValue = productTypeValue;
			}

			public boolean isRecommend() {
				return recommend;
			}

			public void setRecommend(boolean recommend) {
				this.recommend = recommend;
			}

			public int getRemainingAmount() {
				return remainingAmount;
			}

			public void setRemainingAmount(int remainingAmount) {
				this.remainingAmount = remainingAmount;
			}

			public int getSaleAmount() {
				return saleAmount;
			}

			public void setSaleAmount(int saleAmount) {
				this.saleAmount = saleAmount;
			}

			public String getSaleEndTime() {
				return saleEndTime;
			}

			public void setSaleEndTime(String saleEndTime) {
				this.saleEndTime = saleEndTime;
			}

			public String getSaleStartTime() {
				return saleStartTime;
			}

			public void setSaleStartTime(String saleStartTime) {
				this.saleStartTime = saleStartTime;
			}

			public String getStartBuyTime() {
				return startBuyTime;
			}

			public void setStartBuyTime(String startBuyTime) {
				this.startBuyTime = startBuyTime;
			}

			public int getTotalAmount() {
				return totalAmount;
			}

			public void setTotalAmount(int totalAmount) {
				this.totalAmount = totalAmount;
			}

			public int getTotalBuyNumber() {
				return totalBuyNumber;
			}

			public void setTotalBuyNumber(int totalBuyNumber) {
				this.totalBuyNumber = totalBuyNumber;
			}

			public int getTotalCopies() {
				return totalCopies;
			}

			public void setTotalCopies(int totalCopies) {
				this.totalCopies = totalCopies;
			}

			public String getPassTime() {
				return passTime;
			}

			public void setPassTime(String passTime) {
				this.passTime = passTime;
			}

			public String getStartInterestDate() {
				return startInterestDate;
			}

			public void setStartInterestDate(String startInterestDate) {
				this.startInterestDate = startInterestDate;
			}
		}

		public static class ListIconBean {
			/**
			 * carId : 1
			 * cityId : 1
			 * id : 1
			 * productId : 36
			 */

			private int carId;
			private int cityId;
			private int id;
			private int productId;

			public static ListIconBean objectFromData(String str) {

				return new Gson().fromJson(str, ListIconBean.class);
			}

			public int getCarId() {
				return carId;
			}

			public void setCarId(int carId) {
				this.carId = carId;
			}

			public int getCityId() {
				return cityId;
			}

			public void setCityId(int cityId) {
				this.cityId = cityId;
			}

			public int getId() {
				return id;
			}

			public void setId(int id) {
				this.id = id;
			}

			public int getProductId() {
				return productId;
			}

			public void setProductId(int productId) {
				this.productId = productId;
			}
		}
	}

//	private String message;
//	private LoanResults<> loanResults;
//	private String code;
//	private boolean success;

}
