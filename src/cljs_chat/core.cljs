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

(rum/defc message [{:keys [user uid time body src]} message]
  [:.message {:class src}
   [:img.avatar {:src "https://user-images.githubusercontent.com/6009640/31679076-dc7581c6-b391-11e7-87fe-a8fa89793c63.png"}]
   [:.message-buble
    [:.message-meta
     [:.message-user user]
     [:.message-time time]]
    [:.message-text body]]])

(def msg
  {:user "username" ;; GitHub username
   :uid "CEhmVGg3qnpqSnPwAF" ;; uid from firebase auth response
   :time "Fri, 06 Jul 2018 18:19:05 GMT" ;;new Date().toUTCString(),
   :body "message text"})

(rum/defc content []
  [:.content
   (message (assoc msg :src "other"))
   (message (assoc msg :src "me"))])

(rum/defc screen []
  [:.screen
   (header "Clojure Learning Group")
   (content)
   (footer)])

(def user
  {:username "@johndoe"
   :full-name "John Doe"
   :bio "Github bio"})

(rum/defc screen-profile [{:keys [username full-name bio]} user]
  [:.screen.profile
   [:.header
    [:.header-left
     [:small
      [:a {:href "#/chat"} "back to chat"]]]
    [:.header-title username]
    [:.header-right]]
   [:.content
    [:img.avatar.avatar-xl {:src "https://user-images.githubusercontent.com/6009640/31679076-dc7581c6-b391-11e7-87fe-a8fa89793c63.png"}]
    [:.profile-info
     [:.username username]
     [:.full-name full-name]
     [:.bio bio]]
    [:button.button "Upload background"]]])

(rum/mount (screen-profile user)
           (. js/document (getElementById "app")))

(defn on-js-reload []
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)
)


