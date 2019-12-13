
interface BERTags
{
    int BOOLEAN             = 0x01;
    int INTEGER             = 0x02;
    int BIT_STRING          = 0x03;
    int OCTET_STRING        = 0x04;
    int NULL                = 0x05;
    int OBJECT_IDENTIFIER   = 0x06;
    int EXTERNAL            = 0x08;
    int ENUMERATED          = 0x0a; // decimal 10
    int SEQUENCE            = 0x10; // decimal 16
    int SET                 = 0x11; // decimal 17


    int NUMERIC_STRING      = 0x12; // decimal 18
    int PRINTABLE_STRING    = 0x13; // decimal 19
    int T61_STRING          = 0x14; // decimal 20
    int VIDEOTEX_STRING     = 0x15; // decimal 21
    int IA5_STRING          = 0x16; // decimal 22
    int UTC_TIME            = 0x17; // decimal 23
    int GENERALIZED_TIME    = 0x18; // decimal 24
    int GRAPHIC_STRING      = 0x19; // decimal 25
    int VISIBLE_STRING      = 0x1a; // decimal 26
    int GENERAL_STRING      = 0x1b; // decimal 27
    int UNIVERSAL_STRING    = 0x1c; // decimal 28
    int BMP_STRING          = 0x1e; // decimal 30
    int UTF8_STRING         = 0x0c; // decimal 12

    int CONSTRUCTED         = 0x20; // decimal 32
    int APPLICATION         = 0x40; // decimal 64
    int TAGGED              = 0x80; // decimal 128
}
