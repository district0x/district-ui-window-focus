(ns district.ui.window-focus.subs
  (:require
    [district.ui.window-focus.queries :as queries]
    [re-frame.core :refer [reg-sub]]))

(reg-sub
  ::focused?
  queries/focused?)
