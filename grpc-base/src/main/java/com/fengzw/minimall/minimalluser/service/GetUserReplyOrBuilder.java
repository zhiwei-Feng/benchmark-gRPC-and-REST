// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: user.proto

package com.fengzw.minimall.minimalluser.service;

public interface GetUserReplyOrBuilder extends
    // @@protoc_insertion_point(interface_extends:service.GetUserReply)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int64 id = 1;</code>
   * @return The id.
   */
  long getId();

  /**
   * <code>string username = 2;</code>
   * @return The username.
   */
  java.lang.String getUsername();
  /**
   * <code>string username = 2;</code>
   * @return The bytes for username.
   */
  com.google.protobuf.ByteString
      getUsernameBytes();

  /**
   * <code>string password = 3;</code>
   * @return The password.
   */
  java.lang.String getPassword();
  /**
   * <code>string password = 3;</code>
   * @return The bytes for password.
   */
  com.google.protobuf.ByteString
      getPasswordBytes();

  /**
   * <code>string nickname = 4;</code>
   * @return The nickname.
   */
  java.lang.String getNickname();
  /**
   * <code>string nickname = 4;</code>
   * @return The bytes for nickname.
   */
  com.google.protobuf.ByteString
      getNicknameBytes();
}