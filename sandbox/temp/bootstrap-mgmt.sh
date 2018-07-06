#!/usr/bin/env bash
su vagrant <<'EOF'
cp server/keys/private ~/.ssh/id_rsa
cp server/keys/public ~/.ssh/id_rsa.pub
cp server/keys/public ~/.ssh/authorized_keys
chmod 0600 ~/.ssh/*
EOF
