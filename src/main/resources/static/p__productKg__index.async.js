(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([[13],{"/t9W":function(e,a,t){"use strict";var n,s,l=t("q1tI"),r=t.n(l),o=t("K7vz"),c=t("ujA5"),i=t("QttV"),m=t("33Fu"),d=t("MuoO"),j=t("Iu7H"),u=t("X13+"),h=t("ma3e"),p=t("NIcq"),g=(n=Object(d["connect"])(e=>{var a=e.globalModel;return{globalModel:a}}),n(s=class extends l["Component"]{render(){var e=this.props.globalModel,a=e.currentUser,t=e.isMenu,n=(e.isStaff,e.isDirector),s=()=>{this.props.dispatch({type:"globalModel/updateState",payload:{isMenu:!t}})};return r.a.createElement("div",{className:t?" katalog-sidebar w18 ":"katalog-sidebar w0 "},r.a.createElement("div",{className:t?"menuSidebar w16 ":"menuSidebar w0 "},r.a.createElement("div",{className:"userStatus text-center text-white"},r.a.createElement("h5",{className:""},a.firstName),r.a.createElement("div",{className:"m-auto w-25"},r.a.createElement("h6",null,"Online"))),r.a.createElement(o["a"],{className:""},r.a.createElement(c["a"],{className:""},r.a.createElement(i["Link"],{to:"/today",className:"/today"===window.location.pathname?"active-catalog":"nav-link",onClick:window.screen.width<850?s:""},r.a.createElement(m["a"],{className:"list-group-item-icon"})," Bugun")),r.a.createElement(c["a"],null,r.a.createElement(i["Link"],{to:"/month",className:"/month"===window.location.pathname?"active-catalog":"nav-link",onClick:window.screen.width<850?s:""},r.a.createElement(j["a"],{className:"list-group-item-icon"})," Months")),r.a.createElement(c["a"],null,r.a.createElement(i["Link"],{to:"/room",className:"/room"===window.location.pathname?"active-catalog":"nav-link",onClick:window.screen.width<850?s:""},r.a.createElement(u["a"],{className:"list-group-item-icon"})," xonalar")),r.a.createElement(c["a"],null,r.a.createElement(i["Link"],{to:"/product",className:"/product"===window.location.pathname?"active-catalog":"nav-link",onClick:window.screen.width<850?s:""},r.a.createElement(h["a"],{className:"list-group-item-icon"})," Mahsulotlar")),r.a.createElement(c["a"],null,r.a.createElement(i["Link"],{to:"/productKg",className:"/productKg"===window.location.pathname?"active-catalog":"nav-link",onClick:window.screen.width<850?s:""},r.a.createElement(h["a"],{className:"list-group-item-icon"})," Mahsulotlar Kg")),r.a.createElement(c["a"],{className:n?"d-block":"d-none"},r.a.createElement(i["Link"],{to:"/setting",className:"/setting"===window.location.pathname?"active-catalog":"nav-link",onClick:window.screen.width<850?s:""},r.a.createElement(p["a"],{className:"list-group-item-icon"})," Sozlash")))))}})||s),E=g;class v extends l["Component"]{render(){return r.a.createElement("div",{className:"catalog"},r.a.createElement(E,{pathname:this.props.pathname}),this.props.children)}}a["a"]=v},Jx0N:function(e,a,t){"use strict";t.r(a);var n,s,l=t("p0pE"),r=t.n(l),o=t("q1tI"),c=t.n(o),i=t("/t9W"),m=t("XAkp"),d=t("DCcX"),j=t("vkoW"),u=t("CaDr"),h=t("OBzv"),p=t("sOKU"),g=t("kJEY"),E=t("MuoO"),v=t("iNdW"),k=t("v7au"),b=t("CO4e"),w=t("GUC0"),y=t.n(w),x=(n=Object(E["connect"])(e=>{var a=e.productKgModel;return{productKgModel:a}}),n(s=class extends o["Component"]{componentDidMount(){this.props.dispatch({type:"productKgModel/getProductsKg"})}constructor(e){super(e),this.state={summa:0,cost:0},this.handleChange=this.handleChange.bind(this),this.handleChange1=this.handleChange1.bind(this)}handleChange(e){this.setState({summa:e.replace(/ /gi,"")})}handleChange1(e){this.setState({cost:e.replace(/ /gi,"")})}render(){var e=this.props,a=e.dispatch,t=e.productKgModel,n=t.isOpenModal,s=t.productsKg,l=t.productKg,o=e=>{a({type:"productKgModel/updateState",payload:{isOpenModal:!n,productKg:e}})},E=(e,t)=>{t.balance=this.state.summa,t.cost=this.state.cost,a({type:"productKgModel/saveEditProductKg",payload:r()({},t)})},w=e=>{y()({title:"siz shu mahsulotni o'chirmoq chimisiz?",buttons:["yo'q","xa"]}).then(t=>{t&&a({type:"productKgModel/deleteProductKg",payload:{id:e}})})};return c.a.createElement("div",null,c.a.createElement(i["a"],{pathname:this.props.pathname},c.a.createElement("div",{className:"container"},c.a.createElement("div",{className:"row pt-2 pl-md-4"},c.a.createElement("div",{className:"col-md-4 mb-2"},c.a.createElement("button",{className:"btn btn-primary",onClick:()=>o("")},"mahsulot qo'shish")),c.a.createElement("div",{className:"col-md-12"},c.a.createElement("div",{className:"scroll-hide"},c.a.createElement(m["a"],null,c.a.createElement("thead",null,c.a.createElement("tr",null,c.a.createElement("th",null,"\u2116"),c.a.createElement("th",null,"nomi"),c.a.createElement("th",null,"narxi"),c.a.createElement("th",null,"tan narxi"),c.a.createElement("th",{colSpan:"2"},"action"))),c.a.createElement("tbody",null,s.map((e,a)=>c.a.createElement("tr",{key:e.id},c.a.createElement("td",null,a+1),c.a.createElement("td",null,c.a.createElement("h6",null,e.name)),c.a.createElement("td",null,c.a.createElement("h6",null,new Intl.NumberFormat("en-EN").format(e.balance))),c.a.createElement("td",null,c.a.createElement("h6",null,new Intl.NumberFormat("en-EN").format(e.cost))),c.a.createElement("td",null,c.a.createElement(v["a"],{onClick:()=>o(e)})),c.a.createElement("td",null,c.a.createElement(k["a"],{onClick:()=>w(e.id)}))))))))),c.a.createElement(d["a"],{isOpen:n,toggle:o},c.a.createElement(j["a"],null,c.a.createElement("div",null,c.a.createElement("h5",null,"Mahsulot qo'shish kg"))),c.a.createElement(g["AvForm"],{onValidSubmit:E},c.a.createElement("div",null,c.a.createElement(u["a"],null,c.a.createElement(g["AvField"],{name:"id",className:"d-none",value:l?l.id:""}),c.a.createElement(g["AvField"],{name:"name",type:"text",maxLength:"30",value:l?l.name:"",placeholder:"mahsulot nomini kiriting",required:!0}),c.a.createElement(g["AvField"],{className:"w-100 border-secondary rounded",maxLength:"7",tag:b["a"],precision:"0",label:"sotilish narxi",thousandSeparator:" ",name:"balance",onChange:this.handleChange.bind(this),placeholder:"enter payment sum",required:!0}),c.a.createElement(g["AvField"],{className:"w-100 border-secondary rounded",maxLength:"7",tag:b["a"],precision:"0",label:"tan narxi",thousandSeparator:" ",name:"cost",onChange:this.handleChange1.bind(this),placeholder:"enter payment sum",required:!0})),c.a.createElement(h["a"],null,c.a.createElement(p["a"],{type:"button",color:"danger",onClick:()=>o("")},"yopish"),c.a.createElement(p["a"],{color:"success"},"saqlash"))))))))}})||s);a["default"]=x},RnhZ:function(e,a,t){var n={"./af":"K/tc","./af.js":"K/tc","./ar":"jnO4","./ar-dz":"o1bE","./ar-dz.js":"o1bE","./ar-kw":"Qj4J","./ar-kw.js":"Qj4J","./ar-ly":"HP3h","./ar-ly.js":"HP3h","./ar-ma":"CoRJ","./ar-ma.js":"CoRJ","./ar-sa":"gjCT","./ar-sa.js":"gjCT","./ar-tn":"bYM6","./ar-tn.js":"bYM6","./ar.js":"jnO4","./az":"SFxW","./az.js":"SFxW","./be":"H8ED","./be.js":"H8ED","./bg":"hKrs","./bg.js":"hKrs","./bm":"p/rL","./bm.js":"p/rL","./bn":"kEOa","./bn-bd":"loYQ","./bn-bd.js":"loYQ","./bn.js":"kEOa","./bo":"0mo+","./bo.js":"0mo+","./br":"aIdf","./br.js":"aIdf","./bs":"JVSJ","./bs.js":"JVSJ","./ca":"1xZ4","./ca.js":"1xZ4","./cs":"PA2r","./cs.js":"PA2r","./cv":"A+xa","./cv.js":"A+xa","./cy":"l5ep","./cy.js":"l5ep","./da":"DxQv","./da.js":"DxQv","./de":"tGlX","./de-at":"s+uk","./de-at.js":"s+uk","./de-ch":"u3GI","./de-ch.js":"u3GI","./de.js":"tGlX","./dv":"WYrj","./dv.js":"WYrj","./el":"jUeY","./el.js":"jUeY","./en-au":"Dmvi","./en-au.js":"Dmvi","./en-ca":"OIYi","./en-ca.js":"OIYi","./en-gb":"Oaa7","./en-gb.js":"Oaa7","./en-ie":"4dOw","./en-ie.js":"4dOw","./en-il":"czMo","./en-il.js":"czMo","./en-in":"7C5Q","./en-in.js":"7C5Q","./en-nz":"b1Dy","./en-nz.js":"b1Dy","./en-sg":"t+mt","./en-sg.js":"t+mt","./eo":"Zduo","./eo.js":"Zduo","./es":"iYuL","./es-do":"CjzT","./es-do.js":"CjzT","./es-mx":"tbfe","./es-mx.js":"tbfe","./es-us":"Vclq","./es-us.js":"Vclq","./es.js":"iYuL","./et":"7BjC","./et.js":"7BjC","./eu":"D/JM","./eu.js":"D/JM","./fa":"jfSC","./fa.js":"jfSC","./fi":"gekB","./fi.js":"gekB","./fil":"1ppg","./fil.js":"1ppg","./fo":"ByF4","./fo.js":"ByF4","./fr":"nyYc","./fr-ca":"2fjn","./fr-ca.js":"2fjn","./fr-ch":"Dkky","./fr-ch.js":"Dkky","./fr.js":"nyYc","./fy":"cRix","./fy.js":"cRix","./ga":"USCx","./ga.js":"USCx","./gd":"9rRi","./gd.js":"9rRi","./gl":"iEDd","./gl.js":"iEDd","./gom-deva":"qvJo","./gom-deva.js":"qvJo","./gom-latn":"DKr+","./gom-latn.js":"DKr+","./gu":"4MV3","./gu.js":"4MV3","./he":"x6pH","./he.js":"x6pH","./hi":"3E1r","./hi.js":"3E1r","./hr":"S6ln","./hr.js":"S6ln","./hu":"WxRl","./hu.js":"WxRl","./hy-am":"1rYy","./hy-am.js":"1rYy","./id":"UDhR","./id.js":"UDhR","./is":"BVg3","./is.js":"BVg3","./it":"bpih","./it-ch":"bxKX","./it-ch.js":"bxKX","./it.js":"bpih","./ja":"B55N","./ja.js":"B55N","./jv":"tUCv","./jv.js":"tUCv","./ka":"IBtZ","./ka.js":"IBtZ","./kk":"bXm7","./kk.js":"bXm7","./km":"6B0Y","./km.js":"6B0Y","./kn":"PpIw","./kn.js":"PpIw","./ko":"Ivi+","./ko.js":"Ivi+","./ku":"JCF/","./ku.js":"JCF/","./ky":"lgnt","./ky.js":"lgnt","./lb":"RAwQ","./lb.js":"RAwQ","./lo":"sp3z","./lo.js":"sp3z","./lt":"JvlW","./lt.js":"JvlW","./lv":"uXwI","./lv.js":"uXwI","./me":"KTz0","./me.js":"KTz0","./mi":"aIsn","./mi.js":"aIsn","./mk":"aQkU","./mk.js":"aQkU","./ml":"AvvY","./ml.js":"AvvY","./mn":"lYtQ","./mn.js":"lYtQ","./mr":"Ob0Z","./mr.js":"Ob0Z","./ms":"6+QB","./ms-my":"ZAMP","./ms-my.js":"ZAMP","./ms.js":"6+QB","./mt":"G0Uy","./mt.js":"G0Uy","./my":"honF","./my.js":"honF","./nb":"bOMt","./nb.js":"bOMt","./ne":"OjkT","./ne.js":"OjkT","./nl":"+s0g","./nl-be":"2ykv","./nl-be.js":"2ykv","./nl.js":"+s0g","./nn":"uEye","./nn.js":"uEye","./oc-lnc":"Fnuy","./oc-lnc.js":"Fnuy","./pa-in":"8/+R","./pa-in.js":"8/+R","./pl":"jVdC","./pl.js":"jVdC","./pt":"8mBD","./pt-br":"0tRk","./pt-br.js":"0tRk","./pt.js":"8mBD","./ro":"lyxo","./ro.js":"lyxo","./ru":"lXzo","./ru.js":"lXzo","./sd":"Z4QM","./sd.js":"Z4QM","./se":"//9w","./se.js":"//9w","./si":"7aV9","./si.js":"7aV9","./sk":"e+ae","./sk.js":"e+ae","./sl":"gVVK","./sl.js":"gVVK","./sq":"yPMs","./sq.js":"yPMs","./sr":"zx6S","./sr-cyrl":"E+lV","./sr-cyrl.js":"E+lV","./sr.js":"zx6S","./ss":"Ur1D","./ss.js":"Ur1D","./sv":"X709","./sv.js":"X709","./sw":"dNwA","./sw.js":"dNwA","./ta":"PeUW","./ta.js":"PeUW","./te":"XLvN","./te.js":"XLvN","./tet":"V2x9","./tet.js":"V2x9","./tg":"Oxv6","./tg.js":"Oxv6","./th":"EOgW","./th.js":"EOgW","./tk":"Wv91","./tk.js":"Wv91","./tl-ph":"Dzi0","./tl-ph.js":"Dzi0","./tlh":"z3Vd","./tlh.js":"z3Vd","./tr":"DoHr","./tr.js":"DoHr","./tzl":"z1FC","./tzl.js":"z1FC","./tzm":"wQk9","./tzm-latn":"tT3J","./tzm-latn.js":"tT3J","./tzm.js":"wQk9","./ug-cn":"YRex","./ug-cn.js":"YRex","./uk":"raLr","./uk.js":"raLr","./ur":"UpQW","./ur.js":"UpQW","./uz":"Loxo","./uz-latn":"AQ68","./uz-latn.js":"AQ68","./uz.js":"Loxo","./vi":"KSF8","./vi.js":"KSF8","./x-pseudo":"/X5v","./x-pseudo.js":"/X5v","./yo":"fzPg","./yo.js":"fzPg","./zh-cn":"XDpg","./zh-cn.js":"XDpg","./zh-hk":"SatO","./zh-hk.js":"SatO","./zh-mo":"OmwH","./zh-mo.js":"OmwH","./zh-tw":"kOpN","./zh-tw.js":"kOpN"};function s(e){var a=l(e);return t(a)}function l(e){if(!t.o(n,e)){var a=new Error("Cannot find module '"+e+"'");throw a.code="MODULE_NOT_FOUND",a}return n[e]}s.keys=function(){return Object.keys(n)},s.resolve=l,e.exports=s,s.id="RnhZ"}}]);