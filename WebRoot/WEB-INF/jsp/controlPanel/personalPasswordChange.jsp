<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>个人信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
    <link rel="stylesheet" type="text/css" href="resource/css/common/common.css">
    <link rel="stylesheet" type="text/css" href="resource/css/controlPanel/self.css">
    <link rel="stylesheet" type="text/css" href="resource/css/controlPanel/personalInfoList.css">
    <link rel="stylesheet" type="text/css" href="resource/css/controlPanel/password.css">
    <script type="text/javascript" src="resource/script/jquery/jquery.min.js"></script>
    <script type="text/javascript" src="resource/js/controlPanel/personalPasswordChange.js"></script>

  </head>
  
  <body>

<div class="mainDiv">
<div align="center" style="width:516px; margin:0 auto">
  <div id="pnBefore" class="t_zc_tc_a_tizhuce_a">
    <div class="t_zc_tc_a_tizhuce_bg">
      <div class="ywz_zhuce_bao" style="height: 580px; padding: 40px 0 0 0 !important;
                border-right: none !important; margin-bottom: 0px;">
        <div class="t_ywz_fuzai_yi"></div>
        <div class="t_ywz_fuzai_yi"></div>
        <div class="ywz_zhucexiaobo">
          <div class="ywz_zhuce_youjian"> 请输入旧密码：</div>
            <div class="ywz_zhuce_kuangzi">
              <input name="tbPassword" type="password" id="tbOldPassword" class="ywz_zhuce_kuangwenzi1" />
            </div>
        </div>
        <div class="ywz_zhucexiaobo">
          <div class="ywz_zhuce_youjian"> 设置新密码：</div>
          <div class="ywz_zhuce_xiaoxiaobao">
            <div class="ywz_zhuce_kuangzi">
              <input name="tbPassword" type="password" id="tbPassword" class="ywz_zhuce_kuangwenzi1" />
            </div>
            <div class="ywz_zhuce_huixian" id='pwdLevel_1'> </div>
            <div class="ywz_zhuce_huixian" id='pwdLevel_2'> </div>
            <div class="ywz_zhuce_huixian" id='pwdLevel_3'> </div>
            <div class="ywz_zhuce_hongxianwenzi"> 弱</div>
            <div class="ywz_zhuce_hongxianwenzi"> 中</div>
            <div class="ywz_zhuce_hongxianwenzi"> 强</div>
          </div>
          <div class="ywz_zhuce_yongyu1"> <span id="pwd_tip" style="color: #898989"><font style="color: #F00">*</font> 6-16位，由字母（区分大小写）、数字、符号组成</span> <span id="pwd_err" style="color: #f00; display:none;">6-16位，由字母（区分大小写）、数字、符号组成</span> </div>
        </div>
        <div class="ywz_zhucexiaobo">
          <div class="ywz_zhuce_youjian"> 请再次输入新密码：</div>
            <div class="ywz_zhuce_kuangzi">
              <input name="tbPassword" type="password" id="tbPasswordRepeat" class="ywz_zhuce_kuangwenzi1" />
            </div>
        </div>
        <input type="button" id="submit" name="submit" value="确认" onclick="submit($(this))"/>
		<input type="button" id="reset" name="reset" value="重置" onclick="reset($(this))"/>
		<input type="button" id="cancel" name="cancel" value="取消" onclick="javascript:history.back(-1);"/>
      </div>
    </div>
  </div>
</div>
  <script type="text/javascript">

        $('#tbPassword').focus(function () {
            $('#pwdLevel_1').attr('class', 'ywz_zhuce_hongxian');
            $('#tbPassword').keyup();
        });

        $('#tbPassword').keyup(function () {
            var __th = $(this);

            if (!__th.val()) {
                $('#pwd_tip').hide();
                $('#pwd_err').show();
                Primary();
                return;
            }
            if (__th.val().length < 6) {
                $('#pwd_tip').hide();
                $('#pwd_err').show();
                Weak();
                return;
            }
            var _r = checkPassword(__th);
            if (_r < 1) {
                $('#pwd_tip').hide();
                $('#pwd_err').show();
                Primary();
                return;
            }

            if (_r > 0 && _r < 2) {
                Weak();
            } else if (_r >= 2 && _r < 4) {
                Medium();
            } else if (_r >= 4) {
                Tough();
            }

            $('#pwd_tip').hide();
            $('#pwd_err').hide();
        });

     

        function Primary() {
            $('#pwdLevel_1').attr('class', 'ywz_zhuce_huixian');
            $('#pwdLevel_2').attr('class', 'ywz_zhuce_huixian');
            $('#pwdLevel_3').attr('class', 'ywz_zhuce_huixian');
        }

        function Weak() {
            $('#pwdLevel_1').attr('class', 'ywz_zhuce_hongxian');
            $('#pwdLevel_2').attr('class', 'ywz_zhuce_huixian');
            $('#pwdLevel_3').attr('class', 'ywz_zhuce_huixian');
        }

        function Medium() {
            $('#pwdLevel_1').attr('class', 'ywz_zhuce_hongxian');
            $('#pwdLevel_2').attr('class', 'ywz_zhuce_hongxian2');
            $('#pwdLevel_3').attr('class', 'ywz_zhuce_huixian');
        }

        function Tough() {
            $('#pwdLevel_1').attr('class', 'ywz_zhuce_hongxian');
            $('#pwdLevel_2').attr('class', 'ywz_zhuce_hongxian2');
            $('#pwdLevel_3').attr('class', 'ywz_zhuce_hongxian3');
        }




        function checkPassword(pwdinput) {
            var maths, smalls, bigs, corps, cat, num;
            var str = $(pwdinput).val()
            var len = str.length;

            var cat = /.{16}/g
            if (len == 0) return 1;
            if (len > 16) { $(pwdinput).val(str.match(cat)[0]); }
            cat = /.*[\u4e00-\u9fa5]+.*$/
            if (cat.test(str)) {
                return -1;
            }
            cat = /\d/;
            var maths = cat.test(str);
            cat = /[a-z]/;
            var smalls = cat.test(str);
            cat = /[A-Z]/;
            var bigs = cat.test(str);
            var corps = corpses(pwdinput);
            var num = maths + smalls + bigs + corps;

            if (len < 6) { return 1; }

            if (len >= 6 && len <= 8) {
                if (num == 1) return 1;
                if (num == 2 || num == 3) return 2;
                if (num == 4) return 3;
            }

            if (len > 8 && len <= 11) {
                if (num == 1) return 2;
                if (num == 2) return 3;
                if (num == 3) return 4;
                if (num == 4) return 5;
            }

            if (len > 11) {
                if (num == 1) return 3;
                if (num == 2) return 4;
                if (num > 2) return 5;
            }
        }

        function corpses(pwdinput) {
            var cat = /./g
            var str = $(pwdinput).val();
            var sz = str.match(cat)
            for (var i = 0; i < sz.length; i++) {
                cat = /\d/;
                maths_01 = cat.test(sz[i]);
                cat = /[a-z]/;
                smalls_01 = cat.test(sz[i]);
                cat = /[A-Z]/;
                bigs_01 = cat.test(sz[i]);
                if (!maths_01 && !smalls_01 && !bigs_01) { return true; }
            }
            return false;
        }
        
    </script>


</div>

  </body>
</html>
