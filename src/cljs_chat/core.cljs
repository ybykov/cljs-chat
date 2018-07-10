(ns cljs-chat.core
    (:require [rum.core :as rum]))

(enable-console-print!)

(println "This text is printed from src/cljs-chat/core.cljs. Go ahead and edit it and see reloading in action.")

;; define your app data so that it doesn't get over-written on reload

(defonce app-state (atom {:text "Hello world!" :count 0}))

(rum/defc sign-in < rum/reactive []
  [:.screen.sign-in
   [:button.button  "Sign In with GitHub"]])

(rum/mount (sign-in)
           (. js/document (getElementById "app")))

(defn on-js-reload []
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)
)
