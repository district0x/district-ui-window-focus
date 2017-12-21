(ns tests.all
  (:require
    [cljs.test :refer [deftest is testing run-tests async use-fixtures]]
    [day8.re-frame.test :refer [run-test-async run-test-sync wait-for]]
    [district.ui.window-focus.events :as events]
    [district.ui.window-focus.subs :as subs]
    [district.ui.window-focus]
    [mount.core :as mount]
    [re-frame.core :refer [reg-event-fx dispatch-sync subscribe reg-cofx dispatch]]))

(use-fixtures
  :each
  {:after
   (fn []
     (mount/stop))})


(deftest tests
  (run-test-sync
    (let [focused? (subscribe [::subs/focused?])]

      (-> (mount/with-args
            {})
        (mount/start))

      (is (true? @focused?))

      (dispatch [::events/set-focused false])

      (is (false? @focused?)))))



