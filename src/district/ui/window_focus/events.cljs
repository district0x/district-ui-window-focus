(ns district.ui.window-focus.events
  (:require
    [district0x.re-frame.window-fx]
    [district.ui.window-focus.queries :as queries]
    [re-frame.core :refer [reg-event-fx trim-v]]))

(reg-event-fx
  ::start
  (fn [{:keys [:db]}]
    {:db (queries/assoc-focused db true)
     :window/on-focus {:dispatch [::set-focused true]
                       :id ::on-focus}
     :window/on-blur {:dispatch [::set-focused false]
                      :id ::on-blur}}))

(reg-event-fx
  ::set-focused
  [trim-v]
  (fn [{:keys [:db]} [focused?]]
    {:db (queries/assoc-focused db focused?)}))

(reg-event-fx
  ::stop
  (fn [{:keys [:db]}]
    {:db (queries/dissoc-window-focus db)
     :window/stop-on-focus {:id ::on-focus}
     :window/stop-on-blur {:id ::on-blur}}))
