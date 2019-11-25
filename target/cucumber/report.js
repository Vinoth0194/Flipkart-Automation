$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resource/Flipkart.feature");
formatter.feature({
  "name": "FlipKart Functionality.",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@LocusAssignment"
    }
  ]
});
formatter.scenario({
  "name": "Search the product in Flipkart.",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@LocusAssignment"
    },
    {
      "name": "@Search"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "Open Flipkart site",
  "keyword": "Given "
});
formatter.match({
  "location": "Flipkart.open_Flipkart_site()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Check whether the popup displayed",
  "keyword": "And "
});
formatter.match({
  "location": "Flipkart.check_whether_the_popup_displayed()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Cancel the popup",
  "keyword": "Then "
});
formatter.match({
  "location": "Flipkart.cancel_the_popup()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user search a term shoes",
  "keyword": "When "
});
formatter.match({
  "location": "Flipkart.the_user_search_a_term_shoes()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "validate the values whether its searched for shoes.",
  "keyword": "Then "
});
formatter.match({
  "location": "Flipkart.validate_the_values_whether_its_searched_for_shoes()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Apply filter and validate",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@LocusAssignment"
    },
    {
      "name": "@ApplyFilters"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "the user choose two filter",
  "keyword": "When "
});
formatter.match({
  "location": "Flipkart.the_user_choose_two_filter()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Validate whether the filteres are selected",
  "keyword": "Then "
});
formatter.match({
  "location": "Flipkart.validate_whether_the_filteres_are_selected()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Process for buy the product",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@LocusAssignment"
    },
    {
      "name": "@ProductDetailPage"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "the user clicks the first product",
  "keyword": "When "
});
formatter.match({
  "location": "Flipkart.the_user_clicks_the_first_product()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user  select the size of the item",
  "keyword": "And "
});
formatter.match({
  "location": "Flipkart.the_user_select_the_size_of_the_item()"
});
formatter.result({
  "error_message": "org.openqa.selenium.ElementClickInterceptedException: element click intercepted: Element \u003cli class\u003d\"_3hSwtk _2UBURg\" id\u003d\"swatch-0-size\"\u003e...\u003c/li\u003e is not clickable at point (720, 385). Other element would receive the click: \u003cdiv class\u003d\"_2a2WU_ _1MlTd-\"\u003e...\u003c/div\u003e\n  (Session info: chrome\u003d78.0.3904.87)\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:17:03\u0027\nSystem info: host: \u0027FULL049-PRT.FULL.Creative\u0027, ip: \u0027fe80:0:0:0:1411:cdd2:b64e:4f3e%en0\u0027, os.name: \u0027Mac OS X\u0027, os.arch: \u0027x86_64\u0027, os.version: \u002710.15\u0027, java.version: \u00271.8.0_222\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities {acceptInsecureCerts: false, browserName: chrome, browserVersion: 78.0.3904.87, chrome: {chromedriverVersion: 77.0.3865.40 (f484704e052e0..., userDataDir: /var/folders/0p/njmgxkc17xz...}, goog:chromeOptions: {debuggerAddress: localhost:49671}, javascriptEnabled: true, networkConnectionEnabled: false, pageLoadStrategy: normal, platform: MAC, platformName: MAC, proxy: Proxy(), setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify}\nSession ID: 8e4ceb111f9cbb5e7425e6e1d2821afb\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:423)\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.createException(W3CHttpResponseCodec.java:187)\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:122)\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:49)\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:158)\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\n\tat org.openqa.selenium.remote.RemoteWebElement.execute(RemoteWebElement.java:285)\n\tat org.openqa.selenium.remote.RemoteWebElement.click(RemoteWebElement.java:84)\n\tat stepDefinition.Flipkart.the_user_select_the_size_of_the_item(Flipkart.java:212)\n\tat ✽.the user  select the size of the item(file:src/test/resource/Flipkart.feature:23)\n",
  "status": "failed"
});
formatter.step({
  "name": "check whether the user able to see the Buy Now label",
  "keyword": "Then "
});
formatter.match({
  "location": "Flipkart.check_whether_the_user_able_to_see_the_Buy_Now_label()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "clicks the Buy now label",
  "keyword": "And "
});
formatter.match({
  "location": "Flipkart.clicks_the_Buy_now_label()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "should see the login page.",
  "keyword": "Then "
});
formatter.match({
  "location": "Flipkart.should_see_the_login_page()"
});
formatter.result({
  "status": "skipped"
});
});