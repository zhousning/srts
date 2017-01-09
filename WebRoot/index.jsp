<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>电力安全规程多媒体网校培训系统 - 首页</title>
<link href="${pageContext.request.contextPath}/resource/css/common/common.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/resource/css/system/index.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/script/jquery/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/script/highcharts/highcharts.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/script/highcharts/highcharts-more.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/system/index.js"></script>
</head>

<body>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="80" class="index_top_bg"><table width="1100" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td width="800" height="80" class="index_logo" align="right"><embed src="${pageContext.request.contextPath}/resource/flash/system/login_logo.swf" width="650" height="80" type="application/x-shockwave-flash" wmode="transparent" quality="high"></embed></td>
        <td width="150" height="80">&nbsp;</td>
        <td width="150" height="80" class="index_userLogin"><a href="login.jsp">用户登录</a></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td id="index_banner" height="200" valign="bottom" class="index_banner"><table width="1100" border="0" align="center" cellpadding="0" cellspacing="0" class="index_banner_navigation_bg">
      <tr>
        <td id="navigationItem1" width="134" height="40" align="center" onmouseover="mouseInNavigationItem(1)" onmouseout="mouseOutNavigationItem(1)" onmousedown="mouseDownNavigationItem(1)" style="cursor: pointer;">首　页</td>
        <td width="1" height="40" style="background-color:#FFF;"></td>
        <td id="navigationItem2" width="137" height="40" align="center" onmouseover="mouseInNavigationItem(2)" onmouseout="mouseOutNavigationItem(2)" onmousedown="mouseDownNavigationItem(2)" style="cursor: pointer;">信息中心</td>
        <td width="1" height="40" style="background-color:#FFF;"></td>
        <td id="navigationItem3" width="137" height="40" align="center" onmouseover="mouseInNavigationItem(3)" onmouseout="mouseOutNavigationItem(3)" onmousedown="mouseDownNavigationItem(3)" style="cursor: pointer;">培训学习</td>
        <td width="1" height="40" style="background-color:#FFF;"></td>
        <td id="navigationItem4" width="137" height="40" align="center" onmouseover="mouseInNavigationItem(4)" onmouseout="mouseOutNavigationItem(4)" onmousedown="mouseDownNavigationItem(4)" style="cursor: pointer;">在线考试</td>
        <td width="1" height="40" style="background-color:#FFF;"></td>
        <td id="navigationItem5" width="137" height="40" align="center" onmouseover="mouseInNavigationItem(5)" onmouseout="mouseOutNavigationItem(5)" onmousedown="mouseDownNavigationItem(5)" style="cursor: pointer;">知识库</td>
        <td width="1" height="40" style="background-color:#FFF;"></td>
        <td id="navigationItem6" width="137" height="40" align="center" onmouseover="mouseInNavigationItem(6)" onmouseout="mouseOutNavigationItem(6)" onmousedown="mouseDownNavigationItem(6)" style="cursor: pointer;">等级评估</td>
        <td width="1" height="40" style="background-color:#FFF;"></td>
        <td id="navigationItem7" width="137" height="40" align="center" onmouseover="mouseInNavigationItem(7)" onmouseout="mouseOutNavigationItem(7)" onmousedown="mouseDownNavigationItem(7)" style="cursor: pointer;">学习交流</td>
        <td width="1" height="40" style="background-color:#FFF;"></td>
        <td id="navigationItem8" width="137" height="40" align="center" onmouseover="mouseInNavigationItem(8)" onmouseout="mouseOutNavigationItem(8)" onmousedown="mouseDownNavigationItem(8)" style="cursor: pointer;">个人档案</td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td valign="top"><table width="1100" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td colspan="2">&nbsp;</td>
        </tr>
      <tr>
        <td width="550" valign="top"><table width="545" border="0" cellpadding="0" cellspacing="0" class="index_information_bg">
          <tr>
            <td width="199" height="50" align="left" class="index_information_title">通知公告</td>
            <td width="344" height="50" align="right" class="index_information_more"><a href="#">更多...</a></td>
          </tr>
          <tr>
            <td height="200" class="index_messageIcon">&nbsp;</td>
            <td height="200" valign="middle"><table width="100%" border="0" cellspacing="3" cellpadding="0">
              <tr>
                <td height="35"><table width="100%" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td width="8%" height="30" align="center" class="index_information_number1">1</td>
                    <td width="76%" height="30" align="left" class="index_information_content"><a href="#">吉林省电力有限公司吉林省电力...</a></td>
                    <td width="16%" height="30" align="left" class="index_information_content">04/20</td>
                  </tr>
                </table></td>
              </tr>
              <tr>
                <td height="35"><table width="100%" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td width="8%" height="30" align="center" class="index_information_number2">2</td>
                    <td width="76%" height="30" align="left" class="index_information_content"><a href="#">吉林省电力有限公司吉林省电力...</a></td>
                    <td width="16%" height="30" align="left" class="index_information_content">04/20</td>
                  </tr>
                </table></td>
              </tr>
              <tr>
                <td height="35"><table width="100%" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td width="8%" height="30" align="center" class="index_information_number3">3</td>
                    <td width="76%" height="30" align="left" class="index_information_content"><a href="#">吉林省电力有限公司吉林省电力...</a></td>
                    <td width="16%" height="30" align="left" class="index_information_content">04/20</td>
                  </tr>
                </table></td>
              </tr>
              <tr>
                <td height="35"><table width="100%" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td width="8%" height="30" align="center" class="index_information_number4">4</td>
                    <td width="76%" height="30" align="left" class="index_information_content"><a href="#">吉林省电力有限公司吉林省电力...</a></td>
                    <td width="16%" height="30" align="left" class="index_information_content">04/20</td>
                  </tr>
                </table></td>
              </tr>
              <tr>
                <td height="35"><table width="100%" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td width="8%" height="30" align="center" class="index_information_number4">5</td>
                    <td width="76%" height="30" align="left" class="index_information_content"><a href="#">吉林省电力有限公司吉林省电力...</a></td>
                    <td width="16%" height="30" align="left" class="index_information_content">04/20</td>
                  </tr>
                </table></td>
              </tr>
            </table></td>
          </tr>
        </table></td>
        <td width="550" align="right" valign="top"><table width="545" border="0" cellpadding="0" cellspacing="0" class="index_information_bg">
          <tr>
            <td width="199" height="50" align="left" class="index_information_title">新闻中心</td>
            <td width="344" height="50" align="right" class="index_information_more"><a href="#">更多...</a></td>
          </tr>
          <tr>
            <td height="200" class="index_newsIcon">&nbsp;</td>
            <td height="200"><table width="100%" border="0" cellspacing="3" cellpadding="0">
              <tr>
                <td height="35"><table width="100%" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td width="8%" height="30" align="center" class="index_information_number1">1</td>
                    <td width="76%" height="30" align="left" class="index_information_content"><a href="#">吉林省电力有限公司吉林省电力...</a></td>
                    <td width="16%" height="30" align="left" class="index_information_content">04/20</td>
                  </tr>
                </table></td>
              </tr>
              <tr>
                <td height="35"><table width="100%" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td width="8%" height="30" align="center" class="index_information_number2">2</td>
                    <td width="76%" height="30" align="left" class="index_information_content"><a href="#">吉林省电力有限公司吉林省电力...</a></td>
                    <td width="16%" height="30" align="left" class="index_information_content">04/20</td>
                  </tr>
                </table></td>
              </tr>
              <tr>
                <td height="35"><table width="100%" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td width="8%" height="30" align="center" class="index_information_number3">3</td>
                    <td width="76%" height="30" align="left" class="index_information_content"><a href="#">吉林省电力有限公司吉林省电力...</a></td>
                    <td width="16%" height="30" align="left" class="index_information_content">04/20</td>
                  </tr>
                </table></td>
              </tr>
              <tr>
                <td height="35"><table width="100%" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td width="8%" height="30" align="center" class="index_information_number4">4</td>
                    <td width="76%" height="30" align="left" class="index_information_content"><a href="#">吉林省电力有限公司吉林省电力...</a></td>
                    <td width="16%" height="30" align="left" class="index_information_content">04/20</td>
                  </tr>
                </table></td>
              </tr>
              <tr>
                <td height="35"><table width="100%" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td width="8%" height="30" align="center" class="index_information_number4">5</td>
                    <td width="76%" height="30" align="left" class="index_information_content"><a href="#">吉林省电力有限公司吉林省电力...</a></td>
                    <td width="16%" height="30" align="left" class="index_information_content">04/20</td>
                  </tr>
                </table></td>
              </tr>
            </table></td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td colspan="2">&nbsp;</td>
        </tr>
      <tr>
        <td width="550" align="left" valign="top"><table width="545" border="0" cellpadding="0" cellspacing="0" class="index_information_bg">
          <tr>
            <td width="199" height="50" align="left" class="index_information_title">下载专区</td>
            <td width="344" height="50" align="right" class="index_information_more"><a href="#">更多...</a></td>
          </tr>
          <tr>
            <td height="200" class="index_downloadIcon">&nbsp;</td>
            <td height="200"><table width="100%" border="0" cellspacing="3" cellpadding="0">
              <tr>
                <td height="35"><table width="100%" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td width="8%" height="30" align="center" class="index_information_number1">1</td>
                    <td width="76%" height="30" align="left" class="index_information_content"><a href="#">吉林省电力有限公司吉林省电力...</a></td>
                    <td width="16%" height="30" align="left" class="index_information_content">04/20</td>
                  </tr>
                </table></td>
              </tr>
              <tr>
                <td height="35"><table width="100%" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td width="8%" height="30" align="center" class="index_information_number2">2</td>
                    <td width="76%" height="30" align="left" class="index_information_content"><a href="#">吉林省电力有限公司吉林省电力...</a></td>
                    <td width="16%" height="30" align="left" class="index_information_content">04/20</td>
                  </tr>
                </table></td>
              </tr>
              <tr>
                <td height="35"><table width="100%" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td width="8%" height="30" align="center" class="index_information_number3">3</td>
                    <td width="76%" height="30" align="left" class="index_information_content"><a href="#">吉林省电力有限公司吉林省电力...</a></td>
                    <td width="16%" height="30" align="left" class="index_information_content">04/20</td>
                  </tr>
                </table></td>
              </tr>
              <tr>
                <td height="35"><table width="100%" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td width="8%" height="30" align="center" class="index_information_number4">4</td>
                    <td width="76%" height="30" align="left" class="index_information_content"><a href="#">吉林省电力有限公司吉林省电力...</a></td>
                    <td width="16%" height="30" align="left" class="index_information_content">04/20</td>
                  </tr>
                </table></td>
              </tr>
              <tr>
                <td height="35"><table width="100%" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td width="8%" height="30" align="center" class="index_information_number4">5</td>
                    <td width="76%" height="30" align="left" class="index_information_content"><a href="#">吉林省电力有限公司吉林省电力...</a></td>
                    <td width="16%" height="30" align="left" class="index_information_content">04/20</td>
                  </tr>
                </table></td>
              </tr>
            </table></td>
          </tr>
        </table></td>
        <td width="550" align="right" valign="top"><table width="545" border="0" cellpadding="0" cellspacing="0" class="index_information_bg">
          <tr>
            <td width="199" height="50" align="left" class="index_information_title">动态信息</td>
            <td width="344" height="50" align="right" class="index_information_more"><a href="#">更多...</a></td>
          </tr>
          <tr>
            <td height="200" class="index_dynamicIcon">&nbsp;</td>
            <td height="200"><table width="100%" border="0" cellspacing="3" cellpadding="0">
              <tr>
                <td height="35"><table width="100%" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td width="8%" height="30" align="center" class="index_information_number1">1</td>
                    <td width="46%" height="30" align="center" class="index_information_content"><a href="#">注册学员人数：</a></td>
                    <td width="46%" height="30" align="center" class="index_information_contentNumber">3555</td>
                  </tr>
                </table></td>
              </tr>
              <tr>
                <td height="35"><table width="100%" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td width="8%" height="30" align="center" class="index_information_number2">2</td>
                    <td width="46%" height="30" align="center" class="index_information_content">在线学院人数：</td>
                    <td width="46%" height="30" align="center" class="index_information_contentNumber">2000</td>
                  </tr>
                </table></td>
              </tr>
              <tr>
                <td height="35"><table width="100%" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td width="8%" height="30" align="center" class="index_information_number3">3</td>
                    <td width="46%" height="30" align="center" class="index_information_content">完成学时人数：</td>
                    <td width="46%" height="30" align="center" class="index_information_contentNumber">1500</td>
                  </tr>
                </table></td>
              </tr>
              <tr>
                <td height="35"><table width="100%" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td width="8%" height="30" align="center" class="index_information_number4">4</td>
                    <td width="46%" height="30" align="center" class="index_information_content">上传课件数量：</td>
                    <td width="46%" height="30" align="center" class="index_information_contentNumber">5888</td>
                  </tr>
                </table></td>
              </tr>
            </table></td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td colspan="2">&nbsp;</td>
        </tr>
      <tr>
        <td colspan="2"><table width="1100" border="0" cellpadding="0" cellspacing="0" class="index_information_bg">
          <tr>
            <td width="325" height="50" align="left" class="index_information_title">数据统计</td>
            <td width="773" height="50" align="right" class="index_information_more">&nbsp;</td>
          </tr>
          <tr>
            <td id="pieChart" height="300">&nbsp;</td>
            <td id="columnLineAndPieChart" height="300">&nbsp;</td>
          </tr>
        </table></td>
        </tr>
        <tr>
        <td colspan="2">&nbsp;</td>
        </tr>
    </table></td>
  </tr>
  <tr>
    <td height="30" align="center" class="index_bottom index_bottom_bg">Copyright &copy;  电力安全规程多媒体网校培训系统 Beta 1.0</td>
  </tr>
  <tr>
    <td height="25" align="center" class="index_bottom">版权所有 国家电网吉林省电力有限公司 东北电力大学知识工程与能效评估课题组</td>
  </tr>
  <tr>
    <td height="25" align="center" class="index_bottom">建议使用1440*900屏幕分辨率浏览</td>
  </tr>
</table>
</body>
</html>