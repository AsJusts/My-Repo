(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([[8],{"2LYS":function(e,a,t){"use strict";t.r(a);var n=t("p0pE"),r=t.n(n),s=t("d6i3"),p=t.n(s),u=t("abFe");a["default"]={namespace:"fileModel",state:{dataOne:{birthday:"",fullName:"",gender:""}},subscriptions:{},effects:{getDataOnes(e,a){return p.a.mark(function t(){var n,r,s,d;return p.a.wrap(function(t){while(1)switch(t.prev=t.next){case 0:return n=e.payload,r=a.call,s=a.put,t.next=4,r(u["o"],n);case 4:if(d=t.sent,200!==d.statusCode){t.next=8;break}return t.next=8,s({type:"updateState",payload:{dataOne:d}});case 8:case"end":return t.stop()}},t)})()}},reducers:{updateState(e,a){var t=a.payload;return r()({},e,t)}}}}}]);