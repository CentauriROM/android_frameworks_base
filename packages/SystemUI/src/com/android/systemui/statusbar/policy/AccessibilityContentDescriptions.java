/*
 * Copyright (C) 2014 CentauriROM
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.systemui.statusbar.policy;

import com.android.systemui.R;

/**
 * Content descriptions for accessibility support.
 */
public class AccessibilityContentDescriptions {

    private AccessibilityContentDescriptions() {}
    static final int[] PHONE_SIGNAL_STRENGTH = {
        R.string.accessibility_no_phone,
        R.string.accessibility_phone_one_bar,
        R.string.accessibility_phone_two_bars,
        R.string.accessibility_phone_three_bars,
        R.string.accessibility_phone_signal_full
    };

    static final int[] DATA_CONNECTION_STRENGTH = {
        R.string.accessibility_no_data,
        R.string.accessibility_data_one_bar,
        R.string.accessibility_data_two_bars,
        R.string.accessibility_data_three_bars,
        R.string.accessibility_data_signal_full
    };

    static final int[] WIFI_CONNECTION_STRENGTH = {
        R.string.accessibility_no_wifi,
        R.string.accessibility_wifi_one_bar,
        R.string.accessibility_wifi_two_bars,
        R.string.accessibility_wifi_three_bars,
        R.string.accessibility_wifi_signal_full
    };
    static final int[] WIMAX_CONNECTION_STRENGTH = {
        R.string.accessibility_no_wimax,
        R.string.accessibility_wimax_one_bar,
        R.string.accessibility_wimax_two_bars,
        R.string.accessibility_wimax_three_bars,
        R.string.accessibility_wimax_signal_full
    };
}
