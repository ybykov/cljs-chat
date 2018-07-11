(ns cljs-chat.core
    (:require [rum.core :as rum]))

(enable-console-print!)

(println "This text is printed from src/cljs-chat/core.cljs. Go ahead and edit it and see reloading in action.")

;; define your app data so that it doesn't get over-written on reload

(defonce app-state (atom {:text "Hello world!" :count 0}))

(rum/defc sign-in < rum/reactive []
  [:.screen.sign-in
   [:button.button  "Sign In with GitHub"]])

(rum/defc header [title]
  [:.header
   [:.header-left]
   [:.header-title title]
   [:.header-right
    [:img.avatar {:src "https://user-images.githubusercontent.com/6009640/31679076-dc7581c6-b391-11e7-87fe-a8fa89793c63.png"}]]])

(rum/defc footer []
  [:.footer
   [:textarea.input]
   [:button.button "Send"]])

(rum/defc content []
  [:.content])

(rum/defc screen []
  [:.screen
   (header "Clojure Learning Group")
   (content)
   (footer)])

(rum/mount (screen)
           (. js/document (getElementById "app")))

(defn on-js-reload []
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)
)


;; <div class="screen">
;;   <div class="header">
;;     <div class="header-left"></div>
;;     <div class="header-title">Clojure Learning Group</div>
;;     <div class="header-right">
;;       <img class="avatar" src="https://user-images.githubusercontent.com/6009640/31679076-dc7581c6-b391-11e7-87fe-a8fa89793c63.png"></img>
;;     </div>
;;   </div>
;;   <div class="content">
;;     <div class="message other">
;;       <img class="avatar" src="https://user-images.githubusercontent.com/6009640/31679076-dc7581c6-b391-11e7-87fe-a8fa89793c63.png"></img>
;;       <div class="message-buble">
;;         <div class="message-meta">
;;           <div class="message-user">@john01</div>
;;           <div class="message-time">7/2/2018, 11:38:12 PM</div>
;;         </div>
;;         <div class="message-text">
;;           Hello! I’m fineklasdjakshdakjslaksjdkjashjahdkashdjkahsdkjasgdjhagdjhasgdh, thanks!
;;         </div>
;;       </div>
;;     </div>
;;     <div class="message me">
;;       <img class="avatar" src="https://user-images.githubusercontent.com/6009640/31679076-dc7581c6-b391-11e7-87fe-a8fa89793c63.png"></img>
;;       <div class="message-buble">
;;         <div class="message-meta">
;;           <div class="message-user">@mark59</div>
;;           <div class="message-time">7/2/2018, 11:38:12 PM</div>
;;         </div>
;;         <div class="message-text">
;;           Hello! I’m fine, thanks!
;;         </div>
;;       </div>
;;     </div>
;;   </div>
;;   <div class="footer">
;;     <textarea class="input"></textarea>
;;     <button class="button">Send</button>
;;   </div>
;; </div>
