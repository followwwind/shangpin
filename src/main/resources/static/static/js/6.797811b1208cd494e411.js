webpackJsonp([6],{ciwc:function(e,t){},uaRw:function(e,t,n){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var a=n("mvHQ"),o=n.n(a),r={name:"enterpriseCheck",data:function(){return{person:{name:null,idCard:null,accountNo:null,bankPreMobile:null}}},methods:{check:function(){var e=this,t=this;this.person.name&&this.person.accountNo?(document.getElementById("act1").value="查验中...",t.$request({url:"/check/person",method:"POST",data:t.person}).then(function(n){200===n.code&&("400 Bad"===n.data.substr(0,7)?(t.msgError("信息格式错误或请求次数已达上限！"),document.getElementById("act1").value="查验"):e.$router.push({path:"/report/individual",query:{rules1:o()(n.data)}})),document.getElementById("act1").value="查验"}).catch(function(e){document.getElementById("act1").value="查验"})):this.msgError("至少输入银行卡和姓名")},checkRecord:function(){this.$router.push({path:"/checkList"})}}},s={render:function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",[e._m(0),e._v(" "),n("div",{staticClass:"tableContainer"},[n("div",{staticClass:"tableRow"},[n("p",[e._v("姓名")]),e._v(" "),n("p",[n("input",{directives:[{name:"model",rawName:"v-model",value:e.person.name,expression:"person.name"}],attrs:{type:"text"},domProps:{value:e.person.name},on:{input:function(t){t.target.composing||e.$set(e.person,"name",t.target.value)}}})])]),e._v(" "),n("div",{staticClass:"tableRow"},[n("p",[e._v("身份证号")]),e._v(" "),n("p",[n("input",{directives:[{name:"model",rawName:"v-model",value:e.person.idCard,expression:"person.idCard"}],attrs:{type:"text"},domProps:{value:e.person.idCard},on:{input:function(t){t.target.composing||e.$set(e.person,"idCard",t.target.value)}}})])]),e._v(" "),n("div",{staticClass:"tableRow"},[n("p",[e._v("银行卡号")]),e._v(" "),n("p",[n("input",{directives:[{name:"model",rawName:"v-model",value:e.person.accountNo,expression:"person.accountNo"}],attrs:{type:"text"},domProps:{value:e.person.accountNo},on:{input:function(t){t.target.composing||e.$set(e.person,"accountNo",t.target.value)}}})])]),e._v(" "),n("div",{staticClass:"tableRow"},[n("p",[e._v("手机号")]),e._v(" "),n("p",[n("input",{directives:[{name:"model",rawName:"v-model",value:e.person.bankPreMobile,expression:"person.bankPreMobile"}],attrs:{type:"text"},domProps:{value:e.person.bankPreMobile},on:{input:function(t){t.target.composing||e.$set(e.person,"bankPreMobile",t.target.value)}}})])])]),e._v(" "),n("div",{staticClass:"footer",staticStyle:{float:"left","margin-left":"45%","margin-top":"50px"}},[n("input",{attrs:{id:"act1",type:"button",value:"查验"},on:{click:e.check}})])])},staticRenderFns:[function(){var e=this.$createElement,t=this._self._c||e;return t("div",{staticClass:"header"},[t("h2",[this._v("请输入个人信息项")])])}]};var i=n("VU/8")(r,s,!1,function(e){n("ciwc")},"data-v-90e1363a",null);t.default=i.exports}});
//# sourceMappingURL=6.797811b1208cd494e411.js.map