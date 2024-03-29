export function validateSfz(rule, value, callback) {
    if (!value) {
        return callback(new Error('身份证号码不能为空'));
    }
    function validataCredentials(num) {
        var msg, boo; //  msg身份证验证友情提示,boo返回值
        var num = num.toUpperCase(); // 身份证为末尾可能是X
        //   身份证号码为15位或者18位，15位时全为数字，18位前17位为数字，
        //   最后一位是校验位，可能为数字或字符X。
        const arrInt = new Array(7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2);
        const arrCh = new Array('1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2');
        var nTemp = 0,
            i;
        if (!(/(^\d{15}$)|(^\d{17}([0-9]|X)$)/.test(num))) {
            //  输入的身份证号长度不对，或者号码不符合规定;
            return [boo = false, msg = "输入的身份证号长度不对，或者号码不符合规定"];
        }
        //   校验位按照ISO 7064:1983.MOD 11-2的规定生成，X可以认为是数字10。
        //   下面分别分析出生日期和校验位
        var len, re;
        len = num.length;
        if (len == 15) {
            re = new RegExp(/^(\d{6})(\d{2})(\d{2})(\d{2})(\d{3})$/);
            var arrSplit = num.match(re);
            //   检查生日日期是否正确
            var dtmBirth = new Date('19' + arrSplit[2] + '/' + arrSplit[3] + '/' + arrSplit[4]);
            var bGoodDay;
            bGoodDay = (dtmBirth.getYear() == Number(arrSplit[2])) && ((dtmBirth.getMonth() + 1) == Number(arrSplit[3])) && (dtmBirth.getDate() == Number(arrSplit[4]));
            if (!bGoodDay) {
                //   输入的身份证号里出生日期不对！
                return [boo = false, msg = "输入的身份证号里出生日期不对！"];

            } else {
                //   将15位身份证转成18位
                //   校验位按照ISO 7064:1983.MOD 11-2的规定生成，X可以认为是数字10。
                num = num.substr(0, 6) + '19' + num.substr(6, num.length - 6);
                for (i = 0; i < 17; i++) {
                    nTemp += num.substr(i, 1) * arrInt[i];
                }
                num += arrCh[nTemp % 11];
                return [boo = true, msg = num];
            }
        }
        if (len == 18) {
            re = new RegExp(/^(\d{6})(\d{4})(\d{2})(\d{2})(\d{3})([0-9]|X)$/);
            var arrSplit = num.match(re);
            //  检查生日日期是否正确
            var dtmBirth = new Date(arrSplit[2] + "/" + arrSplit[3] + "/" + arrSplit[4]);
            var bGoodDay;
            bGoodDay = (dtmBirth.getFullYear() == Number(arrSplit[2])) && ((dtmBirth.getMonth() + 1) == Number(arrSplit[3])) && (dtmBirth.getDate() == Number(arrSplit[4]));
            if (!bGoodDay) {
                //  输入的身份证号里出生日期不对！

                return [boo = false, msg = " 输入的身份证号里出生日期不对"];
            } else {
                //  检验18位身份证的校验码是否正确。
                //  校验位按照ISO 7064:1983.MOD 11-2的规定生成，X可以认为是数字10。
                var valnum;
                for (i = 0; i < 17; i++) {
                    nTemp += num.substr(i, 1) * arrInt[i];
                }
                valnum = arrCh[nTemp % 11];
                if (valnum != num.substr(17, 1)) {
                    //  18位身份证的校验码不正确！
                    return [boo = false, msg = "身份证的校验码不正确！"];
                }
                return [boo = true, msg = "验证成功"]
            }
        }
        return [boo = false, msg = "身份证的长度不正确！"];
    }
    setTimeout(() => {
        var res = validataCredentials(value);
        if (!res[0]) {
            callback(new Error(res[1]));
        } else {
            callback();
        }
    }, 200);
};
