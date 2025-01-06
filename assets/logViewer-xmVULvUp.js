var J=Object.defineProperty;var M=(o,e,c)=>e in o?J(o,e,{enumerable:!0,configurable:!0,writable:!0,value:c}):o[e]=c;var T=(o,e,c)=>M(o,typeof e!="symbol"?e+"":e,c);import{B as q,D as K,a as B,u as I,g as Q,e as X,_ as Y}from"./index-CbBuSCAE.js";import{f as W,a6 as F,j as f,s as m,t as l,y as r,a2 as _,p as $,n as Z,r as v,a as ee,c as U,a8 as te,I as oe,u as L,k as ae,F as se,P as le,v as b,x as R}from"./libs-JpPrnt1f.js";import{z as ne,aN as re,c as ce,M as A,v as ie,G as ue,b as de,S as pe,F as he,H as fe,T as _e,k as me,n as ge}from"./arcoDesign-CRPk19aq.js";var d=(o=>(o.DEBUG="DEBUG",o.INFO="INFO",o.WARN="WARN",o.ERROR="ERROR",o.TRACE="TRACE",o))(d||{});const we=["onClick"],ye=W({__name:"copier",props:{text:{}},setup(o){const{t:e}=F(),c=async()=>{K(o.text),await new Promise(i=>setTimeout(i,3e3))};return(i,t)=>{const p=ne,h=re,u=ce;return f(),m(q,{once:"","async-fn":c},{default:l(({run:E,loading:g})=>[r(u,{content:_(e)(g?"copier.copied":"copier.copy")},{default:l(()=>[$("span",{class:Z(g?"arco-typography-operation-copied":"arco-typography-operation-copy"),onClick:E},[g?(f(),m(p,{key:0})):(f(),m(h,{key:1}))],10,we)]),_:2},1032,["content"])]),_:1})}}});class ve{constructor(e,c,i){T(this,"_isOpen",!1);T(this,"ws");T(this,"url");const t=new URL(e);this.url=new URL(B(`${t.protocol==="https:"?"wss":"ws"}://${t.host}${t.pathname}`,c)),this.url.searchParams.append("token",i)}get isOpen(){return this._isOpen}get State(){var e;return((e=this.ws)==null?void 0:e.readyState)??WebSocket.CLOSED}open(e,c,i){var t;try{(t=this.ws)==null||t.close(),this.url.searchParams.append("offset",e.toString()),this.ws=new WebSocket(this.url),this.ws.onopen=()=>{this._isOpen=!0},this.ws.onerror=p=>{i(new Error(`WebSocket error: ${p}`))},this.ws.onclose=()=>{this._isOpen=!1},this.ws.onmessage=p=>{try{const h=JSON.parse(p.data);h.success?c(h.data):i(new Error(`WebSocket error: ${h.message}`))}catch{}}}catch(p){return p instanceof Error&&i(p),!1}return!0}close(){var e;this._isOpen&&((e=this.ws)==null||e.close(),this.ws=void 0)}}class be extends ve{constructor(){const e=I();super(e.endpoint,"api/logs/stream",e.authToken)}}async function Re(){const o=I();await o.serverAvailable;const e=new URL(B(o.endpoint,"api/logs/history"),location.href);return fetch(e,{headers:Q()}).then(c=>(o.assertResponseLogin(c),c.json()))}const ke={class:"hover-display-btn"},Se=W({__name:"logViewer",setup(o){const{t:e,d:c}=F(),i=v(!0),t=ee({hideThreads:[],autoScroll:!0,autoRefresh:!1,showLevel:{[d.TRACE]:!1,[d.DEBUG]:!1,[d.INFO]:!0,[d.WARN]:!0,[d.ERROR]:!0}}),p=U(()=>Array.from(h.value).map(s=>({value:s,tagProps:{color:N(s)}}))),h=v(new Set),u=v([]);te(Re,{onSuccess:s=>{u.value.splice(0,u.value.length),u.value.push(...s.data),i.value=!1,s.data.forEach(n=>h.value.add(n.thread))}});const E=U(()=>u.value.filter(s=>t.showLevel[s.level]).filter(s=>!t.hideThreads.includes(s.thread))),g=v(),V=new be,D=async s=>{try{return s?V.open(u.value.length>0?u.value[u.value.length-1].offset:0,n=>{var w;u.value.push(n),h.value.add(n.thread),t.autoScroll&&((w=g.value)==null||w.scrollIntoView({index:u.value.length-1,align:"bottom"}))},n=>{A.error(n.message),t.autoRefresh=!1}):(V.close(),!0)}catch(n){return n instanceof Error&&A.error(n.message),!1}},O=s=>{switch(s){case d.TRACE:return"blue";case d.WARN:return"orange";case d.ERROR:return"red";case d.DEBUG:case d.INFO:default:return"gray"}},N=s=>s.startsWith("virtual-")||s.startsWith("pool")||/Thread-[0-9]+/.test(s)?"gray":X(s,["orange","orangered","red","blue"]);oe(()=>{V.close()});const x=v(!0);return(s,n)=>{const w=ie,y=ue,k=de,S=pe,G=he,P=fe,j=_e,z=me,H=ge;return f(),m(S,{direction:"vertical",class:"container",size:"medium"},{default:l(()=>[r(P,{disabled:i.value,model:t,layout:"inline"},{default:l(()=>[r(y,{field:"autoRefresh",label:_(e)("page.settings.tab.info.log.enableAutoRefresh")},{default:l(()=>[r(w,{modelValue:t.autoRefresh,"onUpdate:modelValue":n[0]||(n[0]=a=>t.autoRefresh=a),"before-change":D},null,8,["modelValue"])]),_:1},8,["label"]),t.autoRefresh?(f(),m(y,{key:0,field:"autoScroll",label:_(e)("page.settings.tab.info.log.autoScorll")},{default:l(()=>[r(w,{modelValue:t.autoScroll,"onUpdate:modelValue":n[1]||(n[1]=a=>t.autoScroll=a)},null,8,["modelValue"])]),_:1},8,["label"])):L("",!0),r(y,{field:"showThreadName",label:_(e)("page.settings.tab.info.log.showThread")},{default:l(()=>[r(w,{modelValue:x.value,"onUpdate:modelValue":n[2]||(n[2]=a=>x.value=a)},null,8,["modelValue"])]),_:1},8,["label"]),r(y,{field:"showLevel",label:_(e)("page.settings.tab.info.log.showLevel")},{default:l(()=>[r(S,null,{default:l(()=>[(f(!0),ae(se,null,le(Object.keys(t.showLevel),a=>(f(),m(k,{key:a,checked:t.showLevel[a],"onUpdate:checked":C=>t.showLevel[a]=C,color:O(a),checkable:""},{default:l(()=>[b(R(a),1)]),_:2},1032,["checked","onUpdate:checked","color"]))),128))]),_:1})]),_:1},8,["label"]),r(y,{field:"hideThreads",label:_(e)("page.settings.tab.info.log.hideThreads")},{default:l(()=>[r(G,{modelValue:t.hideThreads,"onUpdate:modelValue":n[3]||(n[3]=a=>t.hideThreads=a),placeholder:_(e)("page.settings.tab.info.log.hideThreads.placeholder"),style:{width:"15rem"},multiple:"","max-tag-count":1,"allow-create":"",scrollbar:"",options:p.value},null,8,["modelValue","placeholder","options"])]),_:1},8,["label"])]),_:1},8,["disabled","model"]),r(H,{ref_key:"logList",ref:g,size:"small",loading:i.value,scrollbar:"","virtual-list-props":{height:650,buffer:50},data:E.value},{item:l(({item:a,index:C})=>[(f(),m(z,{key:C},{default:l(()=>[r(S,{style:{display:"flex","justify-content":"space-between"},fill:"",class:"log-line-container"},{default:l(()=>[r(S,{class:"log-line"},{default:l(()=>[r(k,{class:"level-tag",color:O(a.level)},{default:l(()=>[b(R(a.level),1)]),_:2},1032,["color"]),r(k,null,{default:l(()=>[b(R(_(c)(a.time,"log")),1)]),_:2},1024),x.value?(f(),m(k,{key:0,color:N(a.thread)},{default:l(()=>[b(R(a.thread),1)]),_:2},1032,["color"])):L("",!0),r(j,{ellipsis:{rows:1,showTooltip:!0}},{default:l(()=>[b(R(a.content),1)]),_:2},1024)]),_:2},1024),$("div",ke,[r(ye,{text:a.content},null,8,["text"])])]),_:2},1024)]),_:2},1024))]),_:1},8,["loading","data"])]),_:1})}}}),Ce=Y(Se,[["__scopeId","data-v-3ad7673d"]]);export{Ce as default};
