webpackJsonp([11],{bqOp:function(e,s,t){"use strict";Object.defineProperty(s,"__esModule",{value:!0});var o=t("BD25"),a=t("BRZl"),n={name:"register",components:{Header:o.a,Footer:a.a},data:function(){return{userInfo:{name:"",email:"",site:"",domainname:"",recordno:"",businessscope:"",password:"",passwordAgain:""}}},methods:{register:function(){var e=this;this.userInfo.name&&this.userInfo.email&&this.userInfo.site&&this.userInfo.domainname&&this.userInfo.recordno&&this.userInfo.businessscope&&this.userInfo.password&&this.userInfo.passwordAgain?this.userInfo.password===this.userInfo.passwordAgain?(this.$request({url:"/user/register",method:"post",data:this.userInfo}).then(function(s){e.msgSuccess(s.msg)}),this.userInfo={}):this.msgError("二次密码不正确"):this.msgError("信息都不能为空")},toLogin:function(){this.$router.push({path:"/index"})}}},r={render:function(){var e=this,s=e.$createElement,t=e._self._c||s;return t("div",[t("Header",{attrs:{title:"注册"}}),e._v(" "),t("div",{staticClass:"tableContainer"},[t("div",{staticClass:"tableRow"},[t("p",[e._v("平台名称")]),e._v(" "),t("p",[t("input",{directives:[{name:"model",rawName:"v-model",value:e.userInfo.name,expression:"userInfo.name"}],staticClass:"side",attrs:{placeholder:"平台名称",type:"text"},domProps:{value:e.userInfo.name},on:{input:function(s){s.target.composing||e.$set(e.userInfo,"name",s.target.value)}}})])]),e._v(" "),t("div",{staticClass:"tableRow"},[t("p",[e._v("平台邮箱")]),e._v(" "),t("p",[t("input",{directives:[{name:"model",rawName:"v-model",value:e.userInfo.email,expression:"userInfo.email"}],staticClass:"side",attrs:{placeholder:"平台邮箱",type:"text"},domProps:{value:e.userInfo.email},on:{input:function(s){s.target.composing||e.$set(e.userInfo,"email",s.target.value)}}})])]),e._v(" "),t("div",{staticClass:"tableRow"},[t("p",[e._v("备案网址")]),e._v(" "),t("p",[t("input",{directives:[{name:"model",rawName:"v-model",value:e.userInfo.site,expression:"userInfo.site"}],staticClass:"side",attrs:{placeholder:"备案网址",type:"text"},domProps:{value:e.userInfo.site},on:{input:function(s){s.target.composing||e.$set(e.userInfo,"site",s.target.value)}}})])]),e._v(" "),t("div",{staticClass:"tableRow"},[t("p",[e._v("备案域名")]),e._v(" "),t("p",[t("input",{directives:[{name:"model",rawName:"v-model",value:e.userInfo.domainname,expression:"userInfo.domainname"}],staticClass:"side",attrs:{placeholder:"备案域名",type:"text"},domProps:{value:e.userInfo.domainname},on:{input:function(s){s.target.composing||e.$set(e.userInfo,"domainname",s.target.value)}}})])]),e._v(" "),t("div",{staticClass:"tableRow"},[t("p",[e._v("备案号")]),e._v(" "),t("p",[t("input",{directives:[{name:"model",rawName:"v-model",value:e.userInfo.recordno,expression:"userInfo.recordno"}],staticClass:"side",attrs:{placeholder:"备案号",type:"text"},domProps:{value:e.userInfo.recordno},on:{input:function(s){s.target.composing||e.$set(e.userInfo,"recordno",s.target.value)}}})])]),e._v(" "),t("div",{staticClass:"tableRow"},[t("p",[e._v("经营范围")]),e._v(" "),t("p",[t("input",{directives:[{name:"model",rawName:"v-model",value:e.userInfo.businessscope,expression:"userInfo.businessscope"}],staticClass:"side",attrs:{placeholder:"经营范围",type:"text"},domProps:{value:e.userInfo.businessscope},on:{input:function(s){s.target.composing||e.$set(e.userInfo,"businessscope",s.target.value)}}})])]),e._v(" "),t("div",{staticClass:"tableRow"},[t("p",[e._v("注册密码")]),e._v(" "),t("p",[t("input",{directives:[{name:"model",rawName:"v-model",value:e.userInfo.password,expression:"userInfo.password"}],staticClass:"side",attrs:{placeholder:"注册密码",type:"text"},domProps:{value:e.userInfo.password},on:{input:function(s){s.target.composing||e.$set(e.userInfo,"password",s.target.value)}}})])]),e._v(" "),t("div",{staticClass:"tableRow"},[t("p",[e._v("确认密码")]),e._v(" "),t("p",[t("input",{directives:[{name:"model",rawName:"v-model",value:e.userInfo.passwordAgain,expression:"userInfo.passwordAgain"}],staticClass:"side",attrs:{placeholder:"确认密码",type:"text"},domProps:{value:e.userInfo.passwordAgain},on:{input:function(s){s.target.composing||e.$set(e.userInfo,"passwordAgain",s.target.value)}}})])]),e._v(" "),t("div",{attrs:{id:"button"}},[t("input",{staticClass:"item",attrs:{type:"button",value:"注册"},on:{click:e.register}}),e._v(" "),t("input",{staticClass:"item",attrs:{type:"button",value:"去登录"},on:{click:e.toLogin}})])]),e._v(" "),t("Footer")],1)},staticRenderFns:[]};var i=t("VU/8")(n,r,!1,function(e){t("eVZM")},null,null);s.default=i.exports},eVZM:function(e,s){}});
//# sourceMappingURL=11.59a4ef422fdf6302f149.js.map