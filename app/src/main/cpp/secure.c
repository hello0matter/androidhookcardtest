// Native secret vault + runtime self-protection.
//
// Design: this .so stores only XOR-encoded bytes of every sensitive string
// (base url, AES key, endpoint paths, version). It NEVER reconstructs the
// plaintext here -- nb() hands the still-encoded bytes back to Java, and the
// Java-side Codec applies the matching unmask. So neither the DEX nor the .so
// contains a readable copy: an attacker needs both halves plus the algorithm.
//
// The encoded tables below are generated; the mask formula must stay in sync
// with com.example.msphone.Codec.unblob(byte[], int).

#include <jni.h>
#include <string.h>
#include <stdlib.h>
#include <stdio.h>

// --- generated encoded blobs (see tools/gen_blobs.py) ---
static const unsigned char B0[] = {0x32,0x31,0x10,0x77,0x1c,0xee,0xcf,0xb6,0x92,0x63,0x5d,0x3e,0x1a,0xe7,0xd9,0xba,0x99,0x7b,0x45,0x25,0x07};
static const unsigned char B1[] = {0x2c,0x30,0x10,0x74,0x54,0xb0,0x90,0xfc,0xdc,0x3a,0x4a,0x2a,0x0a,0xea,0xca,0xaa};
static const unsigned char B2[] = {0xfb};
static const unsigned char B3[] = {0xa0,0xfb,0xd0,0xbf,0x9a,0x3b,0x43,0x33,0x05,0xf1,0xdf,0xa3};
static const unsigned char B4[] = {0x69,0x3d,0x1d,0x6d,0x53,0xbe,0x99,0xb0,0xcc,0x34,0x17,0x7a,0x41,0xa1,0x91,0xe5};
static const unsigned char B5[] = {0x16,0x42,0x62,0x12,0x2c,0xc1,0xe6,0xcf,0xa9,0x4b,0x6e,0x1e,0x39,0xc8,0xee,0x89,0xbd};
static const unsigned char B6[] = {0xdf,0x8b,0xab,0xdb,0xe5,0x08,0x2f,0x06,0x69,0x84,0xad};
static const unsigned char B7[] = {0x9a,0x81,0xa3};

static const unsigned char* const BLOBS[] = {B0,B1,B2,B3,B4,B5,B6,B7};
static const int LENS[] = {21,16,1,12,16,17,11,3};
#define NBLOBS 8

// Expected app signing-cert SHA-256, XOR-encoded the same way (id = 99).
// Left empty by default so a debug/unsigned build is not bricked. Fill via
// tools/gen_blobs.py once you sign with the release keystore (see HARDENING.md).
static const unsigned char SIGEXP[] = {0};
#define SIGEXP_LEN 0

JNIEXPORT jbyteArray JNICALL
Java_com_example_msphone_Vault_nb(JNIEnv* env, jclass clazz, jint id) {
    (void) clazz;
    if (id < 0 || id >= NBLOBS) return NULL;
    int n = LENS[id];
    jbyteArray out = (*env)->NewByteArray(env, n);
    if (out == NULL) return NULL;
    (*env)->SetByteArrayRegion(env, out, 0, n, (const jbyte*) BLOBS[id]);
    return out;
}

JNIEXPORT jbyteArray JNICALL
Java_com_example_msphone_Vault_sig(JNIEnv* env, jclass clazz) {
    (void) clazz;
    jbyteArray out = (*env)->NewByteArray(env, SIGEXP_LEN);
    if (out == NULL) return NULL;
    if (SIGEXP_LEN > 0)
        (*env)->SetByteArrayRegion(env, out, 0, SIGEXP_LEN, (const jbyte*) SIGEXP);
    return out;
}

// Returns a bitmask: bit0 = a debugger is attached (TracerPid != 0),
// bit1 = a Frida/instrumentation artifact is mapped into this process.
JNIEXPORT jint JNICALL
Java_com_example_msphone_Vault_ad(JNIEnv* env, jclass clazz) {
    (void) env; (void) clazz;
    int status = 0;

    FILE* sf = fopen("/proc/self/status", "r");
    if (sf) {
        char line[256];
        while (fgets(line, sizeof(line), sf)) {
            if (strncmp(line, "TracerPid:", 10) == 0) {
                if (atoi(line + 10) != 0) status |= 1;
                break;
            }
        }
        fclose(sf);
    }

    FILE* mf = fopen("/proc/self/maps", "r");
    if (mf) {
        char line[512];
        while (fgets(line, sizeof(line), mf)) {
            if (strstr(line, "frida") || strstr(line, "gum-js") ||
                strstr(line, "gadget") || strstr(line, "linjector")) {
                status |= 2;
                break;
            }
        }
        fclose(mf);
    }

    return status;
}
