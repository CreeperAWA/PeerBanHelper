import{u as T}from"./index-DpI-JMw_.js";import{f as E,a6 as S,r as v,af as C,o as I,s as V,t as e,j as D,y as o,v as _,x as f,a2 as n}from"./libs-CkBWo_FM.js";import{w as L,M,c as j,at as q,F as A,au as N,L as $,B as H,q as R,S as O,v as U}from"./arcoDesign-Dk12eio2.js";import{I as z}from"./index-5zQADWG8.js";const X=E({__name:"index",setup(G){const h=T(),{t}=S(),i=v(!1),a=v({rememberPassword:!0,token:h.authToken}),l=v(),y=async({errors:s,values:m})=>{var r,u,d;const c=s?Object.keys(s):[];if(c.length>0){(r=l.value)==null||r.scrollToField(c[0]);return}const{token:p,rememberPassword:g}=m;if(!i.value){i.value=!0,(u=l.value)==null||u.setFields({token:{status:"validating",message:""}});try{await h.setAuthToken(p,g),M.success(t("login.form.login.success"))}catch(k){(d=l.value)==null||d.setFields({token:{status:"error",message:`${t("login.form.login.failed")}  ${k.message}`}})}finally{i.value=!1}}},{query:w}=C();return I(()=>{var s;w.token&&(a.value.token=w.token,(s=l.value)==null||s.$emit("submit",{values:a.value,errors:void 0},new Event("submit")))}),(s,m)=>{const c=j,p=z,g=q,r=A,u=N,d=$,k=H,b=R,x=O,P=U,B=L;return D(),V(B,{justify:"center"},{default:e(()=>[o(P,{xs:24,sm:20,md:16,lg:12,xl:8},{default:e(()=>[o(x,{direction:"vertical",fill:""},{default:e(()=>[o(c,{heading:3},{default:e(()=>[_(f(n(t)("login.form.title")),1)]),_:1}),o(b,{ref_key:"loginForm",ref:l,model:a.value,class:"login-form",layout:"vertical",onSubmit:y},{default:e(()=>[o(r,{field:"token",rules:[{required:!0,message:n(t)("login.form.password.errMsg")}],"validate-trigger":["change","input"],"hide-label":""},{default:e(()=>[o(g,{modelValue:a.value.token,"onUpdate:modelValue":m[0]||(m[0]=F=>a.value.token=F),placeholder:n(t)("login.form.password.placeholder"),"allow-clear":""},{prefix:e(()=>[o(p)]),_:1},8,["modelValue","placeholder"])]),_:1},8,["rules"]),o(r,{field:"rememberPassword",class:"login-form-password-actions"},{default:e(()=>[o(u,{checked:"rememberPassword","model-value":a.value.rememberPassword},{default:e(()=>[_(f(n(t)("login.form.rememberPassword")),1)]),_:1},8,["model-value"]),o(d,{style:{marginLeft:"auto"},href:"https://github.com/PBH-BTN/PeerBanHelper/wiki/%E5%A6%82%E4%BD%95%E9%87%8D%E7%BD%AEToken"},{default:e(()=>[_(f(n(t)("login.form.forgetPassword")),1)]),_:1})]),_:1}),o(k,{type:"primary","html-type":"submit",long:"",loading:i.value},{default:e(()=>[_(f(n(t)("login.form.login")),1)]),_:1},8,["loading"])]),_:1},8,["model"])]),_:1})]),_:1})]),_:1})}}});export{X as default};