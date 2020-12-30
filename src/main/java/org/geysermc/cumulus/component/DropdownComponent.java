/*
 * Copyright (c) 2019-2020 GeyserMC. http://geysermc.org
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

package org.geysermc.cumulus.component;

import java.util.List;
import java.util.function.Function;
import org.geysermc.cumulus.component.impl.DropdownComponentImpl;

public interface DropdownComponent extends Component {
  static DropdownComponent of(String text, List<String> options, int defaultOption) {
    return new DropdownComponentImpl(text, options, defaultOption);
  }

  static Builder builder() {
    return new DropdownComponentImpl.Builder();
  }

  static Builder builder(String text) {
    return builder().text(text);
  }

  List<String> getOptions();

  int getDefaultOption();

  interface Builder {
    Builder text(String text);

    Builder option(String option, boolean isDefault);

    Builder option(String option);

    Builder defaultOption(int defaultOption);

    DropdownComponent build();

    DropdownComponent translateAndBuild(Function<String, String> translator);
  }
}
