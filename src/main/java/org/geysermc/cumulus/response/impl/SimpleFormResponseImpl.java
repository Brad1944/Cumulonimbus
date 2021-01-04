/*
 * Copyright (c) 2020-2021 GeyserMC. http://geysermc.org
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 *
 * @author GeyserMC
 * @link https://github.com/GeyserMC/Cumulus
 */

package org.geysermc.cumulus.response.impl;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.geysermc.cumulus.component.ButtonComponent;
import org.geysermc.cumulus.response.SimpleFormResponse;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public final class SimpleFormResponseImpl implements SimpleFormResponse {
  private static final SimpleFormResponseImpl CLOSED =
      new SimpleFormResponseImpl(true, false, -1, null);
  private static final SimpleFormResponseImpl INVALID =
      new SimpleFormResponseImpl(false, true, -1, null);

  private final boolean closed;
  private final boolean invalid;

  private final int clickedButtonId;
  private final ButtonComponent clickedButton;

  public static SimpleFormResponseImpl closed() {
    return CLOSED;
  }

  public static SimpleFormResponseImpl invalid() {
    return INVALID;
  }

  public static SimpleFormResponseImpl of(int clickedButtonId, ButtonComponent clickedButton) {
    return new SimpleFormResponseImpl(false, false, clickedButtonId, clickedButton);
  }

  public String getClickedButtonText() {
    return clickedButton.getText();
  }
}
