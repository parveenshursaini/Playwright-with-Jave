/**
 * Copyright (c) Microsoft Corporation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.microsoft.playwright.impl;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class ConsoleMessageImpl extends ChannelOwner {
  public ConsoleMessageImpl(ChannelOwner parent, String type, String guid, JsonObject initializer) {
    super(parent, type, guid, initializer);
  }

  public String type() {
    return initializer.get("type").getAsString();
  }

  public String text() {
    return initializer.get("text").getAsString();
  }

//  args(): JSHandle[] {
//    return this._initializer.args.map(JSHandle.from);
//  }

  public static class Location {
    String url;
    int lineNumber;
    int columnNumber;

    @Override
    public String toString() {
      return url +
        ":" + lineNumber +
        ":" + columnNumber;
    }
  }

  public Location location() {
    return new Gson().fromJson(initializer.get("location"), Location.class);
  }
}