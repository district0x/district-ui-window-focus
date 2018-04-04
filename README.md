# district-ui-window-focus

[![Build Status](https://travis-ci.org/district0x/district-ui-window-focus.svg?branch=master)](https://travis-ci.org/district0x/district-ui-window-focus)

Clojurescript [re-mount](https://github.com/district0x/d0x-INFRA/blob/master/re-mount.md) module, that handles browser window/tab focus.

## Installation
Add `[district0x/district-ui-window-focus "1.0.0"]` into your project.clj  
Include `[district.ui.window-focus]` in your CLJS file, where you use `mount/start`

## API Overview

**Warning:** district0x modules are still in early stages, therefore API can change in a future.

- [district.ui.window-focus](#districtuiwindow-focus)
- [district.ui.window-focus.subs](#districtuiwindow-focussubs)
  - [::focused?](#focused?-sub)
- [district.ui.window-focus.events](#districtuiwindow-focusevents)
  - [::focus-changed](#focus-changed)
- [district.ui.window-focus.queries](#districtuiwindow-focusqueries)
  - [focused?](#focused?)
  - [assoc-focused](#assoc-focused)

## district.ui.window-focus
This namespace contains window-focus [mount](https://github.com/tolitius/mount) module.

This module has no configuration params.

```clojure
  (ns my-district.core
    (:require [mount.core :as mount]
              [district.ui.window-focus]))

  (-> (mount/with-args
        {})
    (mount/start))
```

## district.ui.window-focus.subs
re-frame subscriptions provided by this module:

#### <a name="focused?-sub">`::focused?`
Returns browser window/tab is currently focused.

```clojure
(ns my-district.home-page
  (:require [district.ui.window-focus.subs :as window-focus-subs]
            [re-frame.core :refer [subscribe]]))

(defn home-page []
  (let [focused? (subscribe [::window-focus-subs/focused?])]
    (fn []
      (if @focused?
        [:div "Browser tab is focused"]
        [:div "Browser tab is not focused"]))))
```

## district.ui.window-focus.events
re-frame events provided by this module:

#### <a name="focus-changed">`::focus-changed [focused?]`
Event fired when window/tab is focused or blurred. You may want to use [re-frame-forward-events-fx](https://github.com/Day8/re-frame-forward-events-fx)
to hook into this event.    

## district.ui.window-focus.queries
DB queries provided by this module:  
*You should use them in your events, instead of trying to get this module's 
data directly with `get-in` into re-frame db.*

#### <a name="focused?">`focused? [db]`
Returns window-focus instance.

#### <a name="assoc-focused">`assoc-focused [db focused?]`
Associates focused state and returns new re-frame db.

## Development
```bash
lein deps

# To run tests and rerun on changes
lein doo chrome tests
```