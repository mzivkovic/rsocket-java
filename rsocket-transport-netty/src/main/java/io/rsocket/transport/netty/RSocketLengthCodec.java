/*
 * Copyright 2015-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.rsocket.transport.netty;

import static io.rsocket.frame.FrameHeaderFlyweight.FRAME_LENGTH_MASK;
import static io.rsocket.frame.FrameHeaderFlyweight.FRAME_LENGTH_SIZE;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

public class RSocketLengthCodec extends LengthFieldBasedFrameDecoder {
  public RSocketLengthCodec() {
    super(FRAME_LENGTH_MASK, 0, FRAME_LENGTH_SIZE, 0, 0);
  }

  /**
   * Simplified non-netty focused decode usage.
   *
   * @param in the input buffer to read data from.
   * @return decoded buffer or null is none available.
   * @see #decode(ChannelHandlerContext, ByteBuf)
   * @throws Exception if any error happens.
   */
  public Object decode(ByteBuf in) throws Exception {
    return decode(null, in);
  }
}
