secrets = [
    "http://50.114.113.121",       # 0 BASE_URL (nginx reverse proxy)
    "1234567890abcdef",            # 1 AES key
    "/",                           # 2 config endpoint
    "/kami/verify",                # 3 verify
    "/device/register",            # 4 register
    "/device/heartbeat",           # 5 heartbeat
    "/device/ack",                 # 6 ack
    "156",                         # 7 version_shell
]
def mask(i, idd):
    return (0x5A ^ ((i*0x1F)&0xFF) ^ ((idd*0x47)&0xFF)) & 0xFF
lines = []
for idd, s in enumerate(secrets):
    b = s.encode('utf-8')
    enc = [(b[i] ^ mask(i, idd)) & 0xFF for i in range(len(b))]
    arr = ",".join("0x%02x" % x for x in enc)
    lines.append("static const unsigned char B%d[] = {%s};" % (idd, arr))
print("\n".join(lines))
print()
print("static const unsigned char* const BLOBS[] = {%s};" % ",".join("B%d"%i for i in range(len(secrets))))
print("static const int LENS[] = {%s};" % ",".join(str(len(s.encode('utf-8'))) for s in secrets))
print("#define NBLOBS %d" % len(secrets))
