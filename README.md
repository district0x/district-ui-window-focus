# district-ui-window-focus

[![Build Status](https://travis-ci.org/district0x/district-ui-window-focus.svg?branch=master)](https://travis-ci.org/district0x/district-ui-window-focus)

Clojurescript [mount](https://github.com/tolitius/mount) + [re-frame](https://github.com/Day8/re-frame) module for a district UI, that handles browser window/tab focus.

## Installation
Add `[district0x/district-ui-window-focus "1.0.0"]` into your project.clj  
Include `[district.ui.window-focus]` in your CLJS file, where you use `mount/start`

**Warning:** district0x modules are still in early stages, therefore API can change in a future.

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

#### `::focused?`
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

#### `::start [opts]`
Event fired at mount start.

#### `::focus-changed [focused?]`
Event fired when window/tab is focused or blurred. You may want to use [re-frame-forward-events-fx](https://github.com/Day8/re-frame-forward-events-fx)
to hook into this event.    

#### `::stop`
Cleanup event fired on mount stop.

## district.ui.window-focus.queries
DB queries provided by this module:  
*You should use them in your events, instead of trying to get this module's 
data directly with `get-in` into re-frame db.*

#### `focused? [db]`
Returns window-focus instance.

#### `assoc-focused [db focused?]`
Associates focused state and returns new re-frame db.

#### `dissoc-window-focus [db]`
Cleans up this module from re-frame db. 


## Development
```bash
lein deps

# To run tests and rerun on changes
lein doo chrome tests
```